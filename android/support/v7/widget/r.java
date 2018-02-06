package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.ResourceCursorAdapter;
import android.support.v7.appcompat.R;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;
/* loaded from: classes2.dex */
class r extends ResourceCursorAdapter implements View.OnClickListener {
    private final SearchableInfo UM;
    private final WeakHashMap<String, Drawable.ConstantState> UT;
    private final SearchView Vd;
    private final SearchManager Wb;
    private final Context Wc;
    private final int Wd;
    private int We;
    private ColorStateList Wf;
    private int Wg;
    private int Wh;
    private int Wi;
    private int Wj;
    private int Wk;
    private int Wl;
    private boolean mClosed;

    public r(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), (Cursor) null, true);
        this.mClosed = false;
        this.We = 1;
        this.Wg = -1;
        this.Wh = -1;
        this.Wi = -1;
        this.Wj = -1;
        this.Wk = -1;
        this.Wl = -1;
        this.Wb = (SearchManager) this.mContext.getSystemService("search");
        this.Vd = searchView;
        this.UM = searchableInfo;
        this.Wd = searchView.getSuggestionCommitIconResId();
        this.Wc = context;
        this.UT = weakHashMap;
    }

    public void ce(int i) {
        this.We = i;
    }

    @Override // android.support.v4.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.support.v4.widget.CursorAdapter, android.support.v4.widget.CursorFilter.CursorFilterClient
    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.Vd.getVisibility() == 0 && this.Vd.getWindowVisibility() == 0) {
            try {
                Cursor a2 = a(this.UM, charSequence2, 50);
                if (a2 != null) {
                    a2.getCount();
                    return a2;
                }
            } catch (RuntimeException e) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
            }
            return null;
        }
        return null;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        e(getCursor());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        e(getCursor());
    }

    private void e(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    @Override // android.support.v4.widget.CursorAdapter, android.support.v4.widget.CursorFilter.CursorFilterClient
    public void changeCursor(Cursor cursor) {
        if (this.mClosed) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.changeCursor(cursor);
            if (cursor != null) {
                this.Wg = cursor.getColumnIndex("suggest_text_1");
                this.Wh = cursor.getColumnIndex("suggest_text_2");
                this.Wi = cursor.getColumnIndex("suggest_text_2_url");
                this.Wj = cursor.getColumnIndex("suggest_icon_1");
                this.Wk = cursor.getColumnIndex("suggest_icon_2");
                this.Wl = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    @Override // android.support.v4.widget.ResourceCursorAdapter, android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View newView = super.newView(context, cursor, viewGroup);
        newView.setTag(new a(newView));
        ((ImageView) newView.findViewById(R.id.edit_query)).setImageResource(this.Wd);
        return newView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a {
        public final TextView Wm;
        public final TextView Wn;
        public final ImageView Wo;
        public final ImageView Wp;
        public final ImageView Wq;

        public a(View view) {
            this.Wm = (TextView) view.findViewById(16908308);
            this.Wn = (TextView) view.findViewById(16908309);
            this.Wo = (ImageView) view.findViewById(16908295);
            this.Wp = (ImageView) view.findViewById(16908296);
            this.Wq = (ImageView) view.findViewById(R.id.edit_query);
        }
    }

    @Override // android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        CharSequence a2;
        a aVar = (a) view.getTag();
        int i = this.Wl != -1 ? cursor.getInt(this.Wl) : 0;
        if (aVar.Wm != null) {
            a(aVar.Wm, a(cursor, this.Wg));
        }
        if (aVar.Wn != null) {
            String a3 = a(cursor, this.Wi);
            if (a3 != null) {
                a2 = k(a3);
            } else {
                a2 = a(cursor, this.Wh);
            }
            if (TextUtils.isEmpty(a2)) {
                if (aVar.Wm != null) {
                    aVar.Wm.setSingleLine(false);
                    aVar.Wm.setMaxLines(2);
                }
            } else if (aVar.Wm != null) {
                aVar.Wm.setSingleLine(true);
                aVar.Wm.setMaxLines(1);
            }
            a(aVar.Wn, a2);
        }
        if (aVar.Wo != null) {
            a(aVar.Wo, f(cursor), 4);
        }
        if (aVar.Wp != null) {
            a(aVar.Wp, g(cursor), 8);
        }
        if (this.We == 2 || (this.We == 1 && (i & 1) != 0)) {
            aVar.Wq.setVisibility(0);
            aVar.Wq.setTag(aVar.Wm.getText());
            aVar.Wq.setOnClickListener(this);
            return;
        }
        aVar.Wq.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.Vd.h((CharSequence) tag);
        }
    }

    private CharSequence k(CharSequence charSequence) {
        if (this.Wf == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(R.attr.textColorSearchUrl, typedValue, true);
            this.Wf = this.mContext.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.Wf, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private void a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private Drawable f(Cursor cursor) {
        if (this.Wj == -1) {
            return null;
        }
        Drawable C = C(cursor.getString(this.Wj));
        return C == null ? h(cursor) : C;
    }

    private Drawable g(Cursor cursor) {
        if (this.Wk == -1) {
            return null;
        }
        return C(cursor.getString(this.Wk));
    }

    private void a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    @Override // android.support.v4.widget.CursorAdapter, android.support.v4.widget.CursorFilter.CursorFilterClient
    public CharSequence convertToString(Cursor cursor) {
        String a2;
        String a3;
        if (cursor == null) {
            return null;
        }
        String a4 = a(cursor, "suggest_intent_query");
        if (a4 != null) {
            return a4;
        }
        if (!this.UM.shouldRewriteQueryFromData() || (a3 = a(cursor, "suggest_intent_data")) == null) {
            if (!this.UM.shouldRewriteQueryFromText() || (a2 = a(cursor, "suggest_text_1")) == null) {
                return null;
            }
            return a2;
        }
        return a3;
    }

    @Override // android.support.v4.widget.CursorAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View newView = newView(this.mContext, this.mCursor, viewGroup);
            if (newView != null) {
                ((a) newView.getTag()).Wm.setText(e.toString());
            }
            return newView;
        }
    }

    private Drawable C(String str) {
        if (str == null || str.length() == 0 || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.Wc.getPackageName() + "/" + parseInt;
            Drawable D = D(str2);
            if (D == null) {
                Drawable drawable = ContextCompat.getDrawable(this.Wc, parseInt);
                a(str2, drawable);
                return drawable;
            }
            return D;
        } catch (Resources.NotFoundException e) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException e2) {
            Drawable D2 = D(str);
            if (D2 == null) {
                Drawable f = f(Uri.parse(str));
                a(str, f);
                return f;
            }
            return D2;
        }
    }

    private Drawable f(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return g(uri);
                } catch (Resources.NotFoundException e) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream openInputStream = this.Wc.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
            try {
                openInputStream.close();
                return createFromStream;
            } catch (IOException e2) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e2);
                return createFromStream;
            }
        } catch (FileNotFoundException e3) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
        return null;
    }

    private Drawable D(String str) {
        Drawable.ConstantState constantState = this.UT.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private void a(String str, Drawable drawable) {
        if (drawable != null) {
            this.UT.put(str, drawable.getConstantState());
        }
    }

    private Drawable h(Cursor cursor) {
        Drawable a2 = a(this.UM.getSearchActivity());
        return a2 != null ? a2 : this.mContext.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable a(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        if (this.UT.containsKey(flattenToShortString)) {
            Drawable.ConstantState constantState = this.UT.get(flattenToShortString);
            if (constantState == null) {
                return null;
            }
            return constantState.newDrawable(this.Wc.getResources());
        }
        Drawable activityIcon = getActivityIcon(componentName);
        this.UT.put(flattenToShortString, activityIcon != null ? activityIcon.getConstantState() : null);
        return activityIcon;
    }

    private Drawable getActivityIcon(ComponentName componentName) {
        PackageManager packageManager = this.mContext.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable == null) {
                Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
                return null;
            }
            return drawable;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("SuggestionsAdapter", e.toString());
            return null;
        }
    }

    public static String a(Cursor cursor, String str) {
        return a(cursor, cursor.getColumnIndex(str));
    }

    private static String a(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    Drawable g(Uri uri) throws FileNotFoundException {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.mContext.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException e) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else if (size == 2) {
                identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + uri);
            }
            if (identifier == 0) {
                throw new FileNotFoundException("No resource found for: " + uri);
            }
            return resourcesForApplication.getDrawable(identifier);
        } catch (PackageManager.NameNotFoundException e2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    Cursor a(SearchableInfo searchableInfo, String str, int i) {
        String suggestAuthority;
        String[] strArr;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
            strArr = null;
        }
        if (i > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.mContext.getContentResolver().query(fragment.build(), null, suggestSelection, strArr, null);
    }
}
