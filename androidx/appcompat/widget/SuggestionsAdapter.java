package androidx.appcompat.widget;

import android.annotation.SuppressLint;
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
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.cursoradapter.widget.ResourceCursorAdapter;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.util.UriUtil;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;
@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public class SuggestionsAdapter extends ResourceCursorAdapter implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DBG = false;
    public static final int INVALID_INDEX = -1;
    public static final String LOG_TAG = "SuggestionsAdapter";
    public static final int QUERY_LIMIT = 50;
    public static final int REFINE_ALL = 2;
    public static final int REFINE_BY_ENTRY = 1;
    public static final int REFINE_NONE = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mClosed;
    public final int mCommitIconResId;
    public int mFlagsCol;
    public int mIconName1Col;
    public int mIconName2Col;
    public final WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache;
    public final Context mProviderContext;
    public int mQueryRefinement;
    public final SearchView mSearchView;
    public final SearchableInfo mSearchable;
    public int mText1Col;
    public int mText2Col;
    public int mText2UrlCol;
    public ColorStateList mUrlColor;

    /* loaded from: classes.dex */
    public static final class ChildViewCache {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ImageView mIcon1;
        public final ImageView mIcon2;
        public final ImageView mIconRefine;
        public final TextView mText1;
        public final TextView mText2;

        public ChildViewCache(View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mText1 = (TextView) view.findViewById(16908308);
            this.mText2 = (TextView) view.findViewById(16908309);
            this.mIcon1 = (ImageView) view.findViewById(16908295);
            this.mIcon2 = (ImageView) view.findViewById(16908296);
            this.mIconRefine = (ImageView) view.findViewById(R.id.edit_query);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuggestionsAdapter(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), (Cursor) null, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, searchView, searchableInfo, weakHashMap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue(), (Cursor) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mClosed = false;
        this.mQueryRefinement = 1;
        this.mText1Col = -1;
        this.mText2Col = -1;
        this.mText2UrlCol = -1;
        this.mIconName1Col = -1;
        this.mIconName2Col = -1;
        this.mFlagsCol = -1;
        this.mSearchView = searchView;
        this.mSearchable = searchableInfo;
        this.mCommitIconResId = searchView.getSuggestionCommitIconResId();
        this.mProviderContext = context;
        this.mOutsideDrawablesCache = weakHashMap;
    }

    private Drawable checkIconCache(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            Drawable.ConstantState constantState = this.mOutsideDrawablesCache.get(str);
            if (constantState == null) {
                return null;
            }
            return constantState.newDrawable();
        }
        return (Drawable) invokeL.objValue;
    }

    private CharSequence formatUrl(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, charSequence)) == null) {
            if (this.mUrlColor == null) {
                TypedValue typedValue = new TypedValue();
                this.mContext.getTheme().resolveAttribute(R.attr.textColorSearchUrl, typedValue, true);
                this.mUrlColor = this.mContext.getResources().getColorStateList(typedValue.resourceId);
            }
            SpannableString spannableString = new SpannableString(charSequence);
            spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.mUrlColor, null), 0, charSequence.length(), 33);
            return spannableString;
        }
        return (CharSequence) invokeL.objValue;
    }

    private Drawable getActivityIcon(ComponentName componentName) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, componentName)) == null) {
            PackageManager packageManager = this.mContext.getPackageManager();
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
                int iconResource = activityInfo.getIconResource();
                if (iconResource == 0) {
                    return null;
                }
                Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
                if (drawable == null) {
                    String str = "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString();
                    return null;
                }
                return drawable;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.toString();
                return null;
            }
        }
        return (Drawable) invokeL.objValue;
    }

    private Drawable getActivityIconWithCache(ComponentName componentName) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, componentName)) == null) {
            String flattenToShortString = componentName.flattenToShortString();
            if (this.mOutsideDrawablesCache.containsKey(flattenToShortString)) {
                Drawable.ConstantState constantState = this.mOutsideDrawablesCache.get(flattenToShortString);
                if (constantState == null) {
                    return null;
                }
                return constantState.newDrawable(this.mProviderContext.getResources());
            }
            Drawable activityIcon = getActivityIcon(componentName);
            this.mOutsideDrawablesCache.put(flattenToShortString, activityIcon != null ? activityIcon.getConstantState() : null);
            return activityIcon;
        }
        return (Drawable) invokeL.objValue;
    }

    public static String getColumnString(Cursor cursor, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, cursor, str)) == null) ? getStringOrNull(cursor, cursor.getColumnIndex(str)) : (String) invokeLL.objValue;
    }

    private Drawable getDefaultIcon1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            Drawable activityIconWithCache = getActivityIconWithCache(this.mSearchable.getSearchActivity());
            return activityIconWithCache != null ? activityIconWithCache : this.mContext.getPackageManager().getDefaultActivityIcon();
        }
        return (Drawable) invokeV.objValue;
    }

    private Drawable getDrawable(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, uri)) == null) {
            try {
                if (UriUtil.QUALIFIED_RESOURCE_SCHEME.equals(uri.getScheme())) {
                    try {
                        return getDrawableFromResourceUri(uri);
                    } catch (Resources.NotFoundException unused) {
                        throw new FileNotFoundException("Resource does not exist: " + uri);
                    }
                }
                InputStream openInputStream = this.mProviderContext.getContentResolver().openInputStream(uri);
                if (openInputStream != null) {
                    Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
                    try {
                        openInputStream.close();
                    } catch (IOException unused2) {
                        String str = "Error closing icon stream for " + uri;
                    }
                    return createFromStream;
                }
                throw new FileNotFoundException("Failed to open " + uri);
            } catch (FileNotFoundException e2) {
                String str2 = "Icon not found: " + uri + StringUtil.ARRAY_ELEMENT_SEPARATOR + e2.getMessage();
                return null;
            }
            String str22 = "Icon not found: " + uri + StringUtil.ARRAY_ELEMENT_SEPARATOR + e2.getMessage();
            return null;
        }
        return (Drawable) invokeL.objValue;
    }

    private Drawable getDrawableFromResourceValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, str)) == null) {
            if (str == null || str.isEmpty() || "0".equals(str)) {
                return null;
            }
            try {
                int parseInt = Integer.parseInt(str);
                String str2 = "android.resource://" + this.mProviderContext.getPackageName() + "/" + parseInt;
                Drawable checkIconCache = checkIconCache(str2);
                if (checkIconCache != null) {
                    return checkIconCache;
                }
                Drawable drawable = ContextCompat.getDrawable(this.mProviderContext, parseInt);
                storeInIconCache(str2, drawable);
                return drawable;
            } catch (Resources.NotFoundException unused) {
                String str3 = "Icon resource not found: " + str;
                return null;
            } catch (NumberFormatException unused2) {
                Drawable checkIconCache2 = checkIconCache(str);
                if (checkIconCache2 != null) {
                    return checkIconCache2;
                }
                Drawable drawable2 = getDrawable(Uri.parse(str));
                storeInIconCache(str, drawable2);
                return drawable2;
            }
        }
        return (Drawable) invokeL.objValue;
    }

    private Drawable getIcon1(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, cursor)) == null) {
            int i2 = this.mIconName1Col;
            if (i2 == -1) {
                return null;
            }
            Drawable drawableFromResourceValue = getDrawableFromResourceValue(cursor.getString(i2));
            return drawableFromResourceValue != null ? drawableFromResourceValue : getDefaultIcon1();
        }
        return (Drawable) invokeL.objValue;
    }

    private Drawable getIcon2(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, cursor)) == null) {
            int i2 = this.mIconName2Col;
            if (i2 == -1) {
                return null;
            }
            return getDrawableFromResourceValue(cursor.getString(i2));
        }
        return (Drawable) invokeL.objValue;
    }

    public static String getStringOrNull(Cursor cursor, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65547, null, cursor, i2)) == null) {
            if (i2 == -1) {
                return null;
            }
            try {
                return cursor.getString(i2);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeLI.objValue;
    }

    private void setViewDrawable(ImageView imageView, Drawable drawable, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65548, this, imageView, drawable, i2) == null) {
            imageView.setImageDrawable(drawable);
            if (drawable == null) {
                imageView.setVisibility(i2);
                return;
            }
            imageView.setVisibility(0);
            drawable.setVisible(false, false);
            drawable.setVisible(true, false);
        }
    }

    private void setViewText(TextView textView, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, this, textView, charSequence) == null) {
            textView.setText(charSequence);
            if (TextUtils.isEmpty(charSequence)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
            }
        }
    }

    private void storeInIconCache(String str, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65550, this, str, drawable) == null) || drawable == null) {
            return;
        }
        this.mOutsideDrawablesCache.put(str, drawable.getConstantState());
    }

    private void updateSpinnerState(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, cursor) == null) {
            Bundle extras = cursor != null ? cursor.getExtras() : null;
            if (extras == null || extras.getBoolean("in_progress")) {
            }
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        CharSequence stringOrNull;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, view, context, cursor) == null) {
            ChildViewCache childViewCache = (ChildViewCache) view.getTag();
            int i2 = this.mFlagsCol;
            int i3 = i2 != -1 ? cursor.getInt(i2) : 0;
            if (childViewCache.mText1 != null) {
                setViewText(childViewCache.mText1, getStringOrNull(cursor, this.mText1Col));
            }
            if (childViewCache.mText2 != null) {
                String stringOrNull2 = getStringOrNull(cursor, this.mText2UrlCol);
                if (stringOrNull2 != null) {
                    stringOrNull = formatUrl(stringOrNull2);
                } else {
                    stringOrNull = getStringOrNull(cursor, this.mText2Col);
                }
                if (TextUtils.isEmpty(stringOrNull)) {
                    TextView textView = childViewCache.mText1;
                    if (textView != null) {
                        textView.setSingleLine(false);
                        childViewCache.mText1.setMaxLines(2);
                    }
                } else {
                    TextView textView2 = childViewCache.mText1;
                    if (textView2 != null) {
                        textView2.setSingleLine(true);
                        childViewCache.mText1.setMaxLines(1);
                    }
                }
                setViewText(childViewCache.mText2, stringOrNull);
            }
            ImageView imageView = childViewCache.mIcon1;
            if (imageView != null) {
                setViewDrawable(imageView, getIcon1(cursor), 4);
            }
            ImageView imageView2 = childViewCache.mIcon2;
            if (imageView2 != null) {
                setViewDrawable(imageView2, getIcon2(cursor), 8);
            }
            int i4 = this.mQueryRefinement;
            if (i4 != 2 && (i4 != 1 || (i3 & 1) == 0)) {
                childViewCache.mIconRefine.setVisibility(8);
                return;
            }
            childViewCache.mIconRefine.setVisibility(0);
            childViewCache.mIconRefine.setTag(childViewCache.mText1.getText());
            childViewCache.mIconRefine.setOnClickListener(this);
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public void changeCursor(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor) == null) {
            if (this.mClosed) {
                if (cursor != null) {
                    cursor.close();
                    return;
                }
                return;
            }
            try {
                super.changeCursor(cursor);
                if (cursor != null) {
                    this.mText1Col = cursor.getColumnIndex("suggest_text_1");
                    this.mText2Col = cursor.getColumnIndex("suggest_text_2");
                    this.mText2UrlCol = cursor.getColumnIndex("suggest_text_2_url");
                    this.mIconName1Col = cursor.getColumnIndex("suggest_icon_1");
                    this.mIconName2Col = cursor.getColumnIndex("suggest_icon_2");
                    this.mFlagsCol = cursor.getColumnIndex("suggest_flags");
                }
            } catch (Exception unused) {
            }
        }
    }

    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            changeCursor(null);
            this.mClosed = true;
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public CharSequence convertToString(Cursor cursor) {
        InterceptResult invokeL;
        String columnString;
        String columnString2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cursor)) == null) {
            if (cursor == null) {
                return null;
            }
            String columnString3 = getColumnString(cursor, "suggest_intent_query");
            if (columnString3 != null) {
                return columnString3;
            }
            if (!this.mSearchable.shouldRewriteQueryFromData() || (columnString2 = getColumnString(cursor, "suggest_intent_data")) == null) {
                if (!this.mSearchable.shouldRewriteQueryFromText() || (columnString = getColumnString(cursor, "suggest_text_1")) == null) {
                    return null;
                }
                return columnString;
            }
            return columnString2;
        }
        return (CharSequence) invokeL.objValue;
    }

    public Drawable getDrawableFromResourceUri(Uri uri) throws FileNotFoundException {
        InterceptResult invokeL;
        int parseInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, uri)) == null) {
            String authority = uri.getAuthority();
            if (!TextUtils.isEmpty(authority)) {
                try {
                    Resources resourcesForApplication = this.mContext.getPackageManager().getResourcesForApplication(authority);
                    List<String> pathSegments = uri.getPathSegments();
                    if (pathSegments != null) {
                        int size = pathSegments.size();
                        if (size == 1) {
                            try {
                                parseInt = Integer.parseInt(pathSegments.get(0));
                            } catch (NumberFormatException unused) {
                                throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                            }
                        } else if (size == 2) {
                            parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                        } else {
                            throw new FileNotFoundException("More than two path segments: " + uri);
                        }
                        if (parseInt != 0) {
                            return resourcesForApplication.getDrawable(parseInt);
                        }
                        throw new FileNotFoundException("No resource found for: " + uri);
                    }
                    throw new FileNotFoundException("No path: " + uri);
                } catch (PackageManager.NameNotFoundException unused2) {
                    throw new FileNotFoundException("No package found for authority: " + uri);
                }
            }
            throw new FileNotFoundException("No authority: " + uri);
        }
        return (Drawable) invokeL.objValue;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            try {
                return super.getDropDownView(i2, view, viewGroup);
            } catch (RuntimeException e2) {
                View newDropDownView = newDropDownView(this.mContext, this.mCursor, viewGroup);
                if (newDropDownView != null) {
                    ((ChildViewCache) newDropDownView.getTag()).mText1.setText(e2.toString());
                }
                return newDropDownView;
            }
        }
        return (View) invokeILL.objValue;
    }

    public int getQueryRefinement() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mQueryRefinement : invokeV.intValue;
    }

    public Cursor getSearchManagerSuggestions(SearchableInfo searchableInfo, String str, int i2) {
        InterceptResult invokeLLI;
        String suggestAuthority;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048583, this, searchableInfo, str, i2)) == null) {
            String[] strArr = null;
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
            }
            String[] strArr2 = strArr;
            if (i2 > 0) {
                fragment.appendQueryParameter(Constants.EXTRA_CONFIG_LIMIT, String.valueOf(i2));
            }
            return this.mContext.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
        }
        return (Cursor) invokeLLI.objValue;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, view, viewGroup)) == null) {
            try {
                return super.getView(i2, view, viewGroup);
            } catch (RuntimeException e2) {
                View newView = newView(this.mContext, this.mCursor, viewGroup);
                if (newView != null) {
                    ((ChildViewCache) newView.getTag()).mText1.setText(e2.toString());
                }
                return newView;
            }
        }
        return (View) invokeILL.objValue;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.cursoradapter.widget.ResourceCursorAdapter, androidx.cursoradapter.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, context, cursor, viewGroup)) == null) {
            View newView = super.newView(context, cursor, viewGroup);
            newView.setTag(new ChildViewCache(newView));
            ((ImageView) newView.findViewById(R.id.edit_query)).setImageResource(this.mCommitIconResId);
            return newView;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.notifyDataSetChanged();
            updateSpinnerState(getCursor());
        }
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.notifyDataSetInvalidated();
            updateSpinnerState(getCursor());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            Object tag = view.getTag();
            if (tag instanceof CharSequence) {
                this.mSearchView.onQueryRefine((CharSequence) tag);
            }
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, charSequence)) == null) {
            String charSequence2 = charSequence == null ? "" : charSequence.toString();
            if (this.mSearchView.getVisibility() == 0 && this.mSearchView.getWindowVisibility() == 0) {
                try {
                    Cursor searchManagerSuggestions = getSearchManagerSuggestions(this.mSearchable, charSequence2, 50);
                    if (searchManagerSuggestions != null) {
                        searchManagerSuggestions.getCount();
                        return searchManagerSuggestions;
                    }
                } catch (RuntimeException unused) {
                }
            }
            return null;
        }
        return (Cursor) invokeL.objValue;
    }

    public void setQueryRefinement(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.mQueryRefinement = i2;
        }
    }
}
