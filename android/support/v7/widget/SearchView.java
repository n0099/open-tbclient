package android.support.v7.widget;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.annotation.RestrictTo;
import android.support.v4.content.res.ConfigurationHelper;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.appcompat.R;
import android.support.v7.view.CollapsibleActionView;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
/* loaded from: classes2.dex */
public class SearchView extends LinearLayoutCompat implements CollapsibleActionView {
    static final a UO = new a();
    final SearchAutoComplete TZ;
    private boolean UB;
    CursorAdapter UC;
    private boolean UD;
    private CharSequence UE;
    private boolean UF;
    private boolean UG;
    private boolean UH;
    private CharSequence UI;
    private CharSequence UJ;
    private boolean UK;
    private int UL;
    SearchableInfo UM;
    private Bundle UN;
    private Runnable UQ;
    private final Runnable UR;
    private Runnable US;
    private final WeakHashMap<String, Drawable.ConstantState> UT;
    View.OnKeyListener UU;
    private final TextView.OnEditorActionListener UV;
    private final View Ua;
    private final View Ub;
    private final View Uc;
    final ImageView Ud;
    final ImageView Ue;
    final ImageView Uf;
    final ImageView Ug;
    private final View Uh;
    private b Ui;
    private Rect Uj;
    private Rect Uk;
    private int[] Ul;
    private int[] Um;
    private final ImageView Un;
    private final Drawable Uo;
    private final int Up;
    private final int Uq;
    private final Intent Ur;
    private final Intent Us;
    private final CharSequence Ut;
    private OnQueryTextListener Uu;
    private OnCloseListener Uv;
    View.OnFocusChangeListener Uw;
    private OnSuggestionListener Ux;
    private View.OnClickListener Uy;
    private boolean Uz;
    private int mMaxWidth;
    private final View.OnClickListener mOnClickListener;
    private final AdapterView.OnItemClickListener mOnItemClickListener;
    private final AdapterView.OnItemSelectedListener mOnItemSelectedListener;
    private TextWatcher mTextWatcher;

    /* loaded from: classes2.dex */
    public interface OnCloseListener {
        boolean onClose();
    }

    /* loaded from: classes2.dex */
    public interface OnQueryTextListener {
        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    /* loaded from: classes2.dex */
    public interface OnSuggestionListener {
        boolean onSuggestionClick(int i);

        boolean onSuggestionSelect(int i);
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Uj = new Rect();
        this.Uk = new Rect();
        this.Ul = new int[2];
        this.Um = new int[2];
        this.UQ = new Runnable() { // from class: android.support.v7.widget.SearchView.1
            @Override // java.lang.Runnable
            public void run() {
                InputMethodManager inputMethodManager = (InputMethodManager) SearchView.this.getContext().getSystemService("input_method");
                if (inputMethodManager != null) {
                    SearchView.UO.a(inputMethodManager, SearchView.this, 0);
                }
            }
        };
        this.UR = new Runnable() { // from class: android.support.v7.widget.SearchView.5
            @Override // java.lang.Runnable
            public void run() {
                SearchView.this.hE();
            }
        };
        this.US = new Runnable() { // from class: android.support.v7.widget.SearchView.6
            @Override // java.lang.Runnable
            public void run() {
                if (SearchView.this.UC != null && (SearchView.this.UC instanceof r)) {
                    SearchView.this.UC.changeCursor(null);
                }
            }
        };
        this.UT = new WeakHashMap<>();
        this.mOnClickListener = new View.OnClickListener() { // from class: android.support.v7.widget.SearchView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == SearchView.this.Ud) {
                    SearchView.this.hK();
                } else if (view == SearchView.this.Uf) {
                    SearchView.this.hJ();
                } else if (view == SearchView.this.Ue) {
                    SearchView.this.hH();
                } else if (view == SearchView.this.Ug) {
                    SearchView.this.hL();
                } else if (view == SearchView.this.TZ) {
                    SearchView.this.hO();
                }
            }
        };
        this.UU = new View.OnKeyListener() { // from class: android.support.v7.widget.SearchView.11
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i2, KeyEvent keyEvent) {
                if (SearchView.this.UM == null) {
                    return false;
                }
                if (SearchView.this.TZ.isPopupShowing() && SearchView.this.TZ.getListSelection() != -1) {
                    return SearchView.this.a(view, i2, keyEvent);
                }
                if (!SearchView.this.TZ.isEmpty() && KeyEventCompat.hasNoModifiers(keyEvent) && keyEvent.getAction() == 1 && i2 == 66) {
                    view.cancelLongPress();
                    SearchView.this.b(0, (String) null, SearchView.this.TZ.getText().toString());
                    return true;
                }
                return false;
            }
        };
        this.UV = new TextView.OnEditorActionListener() { // from class: android.support.v7.widget.SearchView.12
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                SearchView.this.hH();
                return true;
            }
        };
        this.mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: android.support.v7.widget.SearchView.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                SearchView.this.b(i2, 0, (String) null);
            }
        };
        this.mOnItemSelectedListener = new AdapterView.OnItemSelectedListener() { // from class: android.support.v7.widget.SearchView.3
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
                SearchView.this.bA(i2);
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: android.support.v7.widget.SearchView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                SearchView.this.j(charSequence);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.SearchView, i, 0);
        LayoutInflater.from(context).inflate(obtainStyledAttributes.getResourceId(R.styleable.SearchView_layout, R.layout.abc_search_view), (ViewGroup) this, true);
        this.TZ = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.TZ.setSearchView(this);
        this.Ua = findViewById(R.id.search_edit_frame);
        this.Ub = findViewById(R.id.search_plate);
        this.Uc = findViewById(R.id.submit_area);
        this.Ud = (ImageView) findViewById(R.id.search_button);
        this.Ue = (ImageView) findViewById(R.id.search_go_btn);
        this.Uf = (ImageView) findViewById(R.id.search_close_btn);
        this.Ug = (ImageView) findViewById(R.id.search_voice_btn);
        this.Un = (ImageView) findViewById(R.id.search_mag_icon);
        ViewCompat.setBackground(this.Ub, obtainStyledAttributes.getDrawable(R.styleable.SearchView_queryBackground));
        ViewCompat.setBackground(this.Uc, obtainStyledAttributes.getDrawable(R.styleable.SearchView_submitBackground));
        this.Ud.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_searchIcon));
        this.Ue.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_goIcon));
        this.Uf.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_closeIcon));
        this.Ug.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_voiceIcon));
        this.Un.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_searchIcon));
        this.Uo = obtainStyledAttributes.getDrawable(R.styleable.SearchView_searchHintIcon);
        this.Up = obtainStyledAttributes.getResourceId(R.styleable.SearchView_suggestionRowLayout, R.layout.abc_search_dropdown_item_icons_2line);
        this.Uq = obtainStyledAttributes.getResourceId(R.styleable.SearchView_commitIcon, 0);
        this.Ud.setOnClickListener(this.mOnClickListener);
        this.Uf.setOnClickListener(this.mOnClickListener);
        this.Ue.setOnClickListener(this.mOnClickListener);
        this.Ug.setOnClickListener(this.mOnClickListener);
        this.TZ.setOnClickListener(this.mOnClickListener);
        this.TZ.addTextChangedListener(this.mTextWatcher);
        this.TZ.setOnEditorActionListener(this.UV);
        this.TZ.setOnItemClickListener(this.mOnItemClickListener);
        this.TZ.setOnItemSelectedListener(this.mOnItemSelectedListener);
        this.TZ.setOnKeyListener(this.UU);
        this.TZ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: android.support.v7.widget.SearchView.7
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (SearchView.this.Uw != null) {
                    SearchView.this.Uw.onFocusChange(SearchView.this, z);
                }
            }
        });
        setIconifiedByDefault(obtainStyledAttributes.getBoolean(R.styleable.SearchView_iconifiedByDefault, true));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SearchView_android_maxWidth, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.Ut = obtainStyledAttributes.getText(R.styleable.SearchView_defaultQueryHint);
        this.UE = obtainStyledAttributes.getText(R.styleable.SearchView_queryHint);
        int i2 = obtainStyledAttributes.getInt(R.styleable.SearchView_android_imeOptions, -1);
        if (i2 != -1) {
            setImeOptions(i2);
        }
        int i3 = obtainStyledAttributes.getInt(R.styleable.SearchView_android_inputType, -1);
        if (i3 != -1) {
            setInputType(i3);
        }
        setFocusable(obtainStyledAttributes.getBoolean(R.styleable.SearchView_android_focusable, true));
        obtainStyledAttributes.recycle();
        this.Ur = new Intent("android.speech.action.WEB_SEARCH");
        this.Ur.addFlags(268435456);
        this.Ur.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.Us = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.Us.addFlags(268435456);
        this.Uh = findViewById(this.TZ.getDropDownAnchor());
        if (this.Uh != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                hx();
            } else {
                hy();
            }
        }
        L(this.Uz);
        hF();
    }

    @TargetApi(11)
    private void hx() {
        this.Uh.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: android.support.v7.widget.SearchView.8
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                SearchView.this.hN();
            }
        });
    }

    private void hy() {
        this.Uh.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.widget.SearchView.9
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                SearchView.this.hN();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSuggestionRowLayout() {
        return this.Up;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSuggestionCommitIconResId() {
        return this.Uq;
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.UM = searchableInfo;
        if (this.UM != null) {
            hG();
            hF();
        }
        this.UH = hz();
        if (this.UH) {
            this.TZ.setPrivateImeOptions("nm");
        }
        L(isIconified());
    }

    @RestrictTo
    public void setAppSearchData(Bundle bundle) {
        this.UN = bundle;
    }

    public void setImeOptions(int i) {
        this.TZ.setImeOptions(i);
    }

    public int getImeOptions() {
        return this.TZ.getImeOptions();
    }

    public void setInputType(int i) {
        this.TZ.setInputType(i);
    }

    public int getInputType() {
        return this.TZ.getInputType();
    }

    @Override // android.view.ViewGroup, android.view.View
    @RestrictTo
    public boolean requestFocus(int i, Rect rect) {
        if (!this.UG && isFocusable()) {
            if (!isIconified()) {
                boolean requestFocus = this.TZ.requestFocus(i, rect);
                if (requestFocus) {
                    L(false);
                }
                return requestFocus;
            }
            return super.requestFocus(i, rect);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    @RestrictTo
    public void clearFocus() {
        this.UG = true;
        setImeVisibility(false);
        super.clearFocus();
        this.TZ.clearFocus();
        this.UG = false;
    }

    public void setOnQueryTextListener(OnQueryTextListener onQueryTextListener) {
        this.Uu = onQueryTextListener;
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.Uv = onCloseListener;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.Uw = onFocusChangeListener;
    }

    public void setOnSuggestionListener(OnSuggestionListener onSuggestionListener) {
        this.Ux = onSuggestionListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.Uy = onClickListener;
    }

    public CharSequence getQuery() {
        return this.TZ.getText();
    }

    public void setQuery(CharSequence charSequence, boolean z) {
        this.TZ.setText(charSequence);
        if (charSequence != null) {
            this.TZ.setSelection(this.TZ.length());
            this.UJ = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            hH();
        }
    }

    public void setQueryHint(CharSequence charSequence) {
        this.UE = charSequence;
        hF();
    }

    public CharSequence getQueryHint() {
        if (this.UE != null) {
            return this.UE;
        }
        if (this.UM != null && this.UM.getHintId() != 0) {
            return getContext().getText(this.UM.getHintId());
        }
        return this.Ut;
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.Uz != z) {
            this.Uz = z;
            L(z);
            hF();
        }
    }

    public boolean isIconfiedByDefault() {
        return this.Uz;
    }

    public void setIconified(boolean z) {
        if (z) {
            hJ();
        } else {
            hK();
        }
    }

    public boolean isIconified() {
        return this.UB;
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.UD = z;
        L(isIconified());
    }

    public boolean isSubmitButtonEnabled() {
        return this.UD;
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.UF = z;
        if (this.UC instanceof r) {
            ((r) this.UC).ce(z ? 2 : 1);
        }
    }

    public boolean isQueryRefinementEnabled() {
        return this.UF;
    }

    public void setSuggestionsAdapter(CursorAdapter cursorAdapter) {
        this.UC = cursorAdapter;
        this.TZ.setAdapter(this.UC);
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.UC;
    }

    public void setMaxWidth(int i) {
        this.mMaxWidth = i;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i, int i2) {
        if (isIconified()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                if (this.mMaxWidth > 0) {
                    size = Math.min(this.mMaxWidth, size);
                    break;
                } else {
                    size = Math.min(getPreferredWidth(), size);
                    break;
                }
            case 0:
                if (this.mMaxWidth <= 0) {
                    size = getPreferredWidth();
                    break;
                } else {
                    size = this.mMaxWidth;
                    break;
                }
            case 1073741824:
                if (this.mMaxWidth > 0) {
                    size = Math.min(this.mMaxWidth, size);
                    break;
                }
                break;
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        switch (mode2) {
            case Integer.MIN_VALUE:
                size2 = Math.min(getPreferredHeight(), size2);
                break;
            case 0:
                size2 = getPreferredHeight();
                break;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            e(this.TZ, this.Uj);
            this.Uk.set(this.Uj.left, 0, this.Uj.right, i4 - i2);
            if (this.Ui == null) {
                this.Ui = new b(this.Uk, this.Uj, this.TZ);
                setTouchDelegate(this.Ui);
                return;
            }
            this.Ui.a(this.Uk, this.Uj);
        }
    }

    private void e(View view, Rect rect) {
        view.getLocationInWindow(this.Ul);
        getLocationInWindow(this.Um);
        int i = this.Ul[1] - this.Um[1];
        int i2 = this.Ul[0] - this.Um[0];
        rect.set(i2, i, view.getWidth() + i2, view.getHeight() + i);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    private void L(boolean z) {
        int i = 8;
        this.UB = z;
        int i2 = z ? 0 : 8;
        boolean z2 = !TextUtils.isEmpty(this.TZ.getText());
        this.Ud.setVisibility(i2);
        M(z2);
        this.Ua.setVisibility(z ? 8 : 0);
        if (this.Un.getDrawable() != null && !this.Uz) {
            i = 0;
        }
        this.Un.setVisibility(i);
        hC();
        N(z2 ? false : true);
        hB();
    }

    private boolean hz() {
        if (this.UM == null || !this.UM.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.UM.getVoiceSearchLaunchWebSearch()) {
            intent = this.Ur;
        } else if (this.UM.getVoiceSearchLaunchRecognizer()) {
            intent = this.Us;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    private boolean hA() {
        return (this.UD || this.UH) && !isIconified();
    }

    private void M(boolean z) {
        int i = 8;
        if (this.UD && hA() && hasFocus() && (z || !this.UH)) {
            i = 0;
        }
        this.Ue.setVisibility(i);
    }

    private void hB() {
        int i = 8;
        if (hA() && (this.Ue.getVisibility() == 0 || this.Ug.getVisibility() == 0)) {
            i = 0;
        }
        this.Uc.setVisibility(i);
    }

    private void hC() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.TZ.getText());
        if (!z2 && (!this.Uz || this.UK)) {
            z = false;
        }
        this.Uf.setVisibility(z ? 0 : 8);
        Drawable drawable = this.Uf.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void hD() {
        post(this.UR);
    }

    void hE() {
        int[] iArr = this.TZ.hasFocus() ? FOCUSED_STATE_SET : EMPTY_STATE_SET;
        Drawable background = this.Ub.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.Uc.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.UR);
        post(this.US);
        super.onDetachedFromWindow();
    }

    void setImeVisibility(boolean z) {
        if (z) {
            post(this.UQ);
            return;
        }
        removeCallbacks(this.UQ);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(CharSequence charSequence) {
        setQuery(charSequence);
    }

    boolean a(View view, int i, KeyEvent keyEvent) {
        if (this.UM != null && this.UC != null && keyEvent.getAction() == 0 && KeyEventCompat.hasNoModifiers(keyEvent)) {
            if (i == 66 || i == 84 || i == 61) {
                return b(this.TZ.getListSelection(), 0, (String) null);
            }
            if (i == 21 || i == 22) {
                this.TZ.setSelection(i == 21 ? 0 : this.TZ.length());
                this.TZ.setListSelection(0);
                this.TZ.clearListSelection();
                UO.a(this.TZ, true);
                return true;
            }
            if (i != 19 || this.TZ.getListSelection() != 0) {
            }
            return false;
        }
        return false;
    }

    private CharSequence i(CharSequence charSequence) {
        if (this.Uz && this.Uo != null) {
            int textSize = (int) (this.TZ.getTextSize() * 1.25d);
            this.Uo.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(this.Uo), 1, 2, 33);
            spannableStringBuilder.append(charSequence);
            return spannableStringBuilder;
        }
        return charSequence;
    }

    private void hF() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.TZ;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(i(queryHint));
    }

    private void hG() {
        this.TZ.setThreshold(this.UM.getSuggestThreshold());
        this.TZ.setImeOptions(this.UM.getImeOptions());
        int inputType = this.UM.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.UM.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.TZ.setInputType(inputType);
        if (this.UC != null) {
            this.UC.changeCursor(null);
        }
        if (this.UM.getSuggestAuthority() != null) {
            this.UC = new r(getContext(), this, this.UM, this.UT);
            this.TZ.setAdapter(this.UC);
            ((r) this.UC).ce(this.UF ? 2 : 1);
        }
    }

    private void N(boolean z) {
        int i;
        if (this.UH && !isIconified() && z) {
            i = 0;
            this.Ue.setVisibility(8);
        } else {
            i = 8;
        }
        this.Ug.setVisibility(i);
    }

    void j(CharSequence charSequence) {
        Editable text = this.TZ.getText();
        this.UJ = text;
        boolean z = !TextUtils.isEmpty(text);
        M(z);
        N(z ? false : true);
        hC();
        hB();
        if (this.Uu != null && !TextUtils.equals(charSequence, this.UI)) {
            this.Uu.onQueryTextChange(charSequence.toString());
        }
        this.UI = charSequence.toString();
    }

    void hH() {
        Editable text = this.TZ.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.Uu == null || !this.Uu.onQueryTextSubmit(text.toString())) {
                if (this.UM != null) {
                    b(0, (String) null, text.toString());
                }
                setImeVisibility(false);
                hI();
            }
        }
    }

    private void hI() {
        this.TZ.dismissDropDown();
    }

    void hJ() {
        if (TextUtils.isEmpty(this.TZ.getText())) {
            if (this.Uz) {
                if (this.Uv == null || !this.Uv.onClose()) {
                    clearFocus();
                    L(true);
                    return;
                }
                return;
            }
            return;
        }
        this.TZ.setText("");
        this.TZ.requestFocus();
        setImeVisibility(true);
    }

    void hK() {
        L(false);
        this.TZ.requestFocus();
        setImeVisibility(true);
        if (this.Uy != null) {
            this.Uy.onClick(this);
        }
    }

    void hL() {
        if (this.UM != null) {
            SearchableInfo searchableInfo = this.UM;
            try {
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    getContext().startActivity(a(this.Ur, searchableInfo));
                } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    getContext().startActivity(b(this.Us, searchableInfo));
                }
            } catch (ActivityNotFoundException e) {
                Log.w("SearchView", "Could not find voice search activity");
            }
        }
    }

    void hM() {
        L(isIconified());
        hD();
        if (this.TZ.hasFocus()) {
            hO();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        hD();
    }

    @Override // android.support.v7.view.CollapsibleActionView
    public void onActionViewCollapsed() {
        setQuery("", false);
        clearFocus();
        L(true);
        this.TZ.setImeOptions(this.UL);
        this.UK = false;
    }

    @Override // android.support.v7.view.CollapsibleActionView
    public void onActionViewExpanded() {
        if (!this.UK) {
            this.UK = true;
            this.UL = this.TZ.getImeOptions();
            this.TZ.setImeOptions(this.UL | 33554432);
            this.TZ.setText("");
            setIconified(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() { // from class: android.support.v7.widget.SearchView.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
            /* renamed from: j */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
            /* renamed from: bC */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        });
        boolean Vb;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.Vb = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.Vb));
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.Vb + "}";
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Vb = isIconified();
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        L(savedState.Vb);
        requestLayout();
    }

    void hN() {
        int i;
        int i2;
        if (this.Uh.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.Ub.getPaddingLeft();
            Rect rect = new Rect();
            boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
            if (this.Uz) {
                i = resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width);
            } else {
                i = 0;
            }
            this.TZ.getDropDownBackground().getPadding(rect);
            if (isLayoutRtl) {
                i2 = -rect.left;
            } else {
                i2 = paddingLeft - (rect.left + i);
            }
            this.TZ.setDropDownHorizontalOffset(i2);
            this.TZ.setDropDownWidth((i + ((this.Uh.getWidth() + rect.left) + rect.right)) - paddingLeft);
        }
    }

    boolean b(int i, int i2, String str) {
        if (this.Ux == null || !this.Ux.onSuggestionClick(i)) {
            c(i, 0, null);
            setImeVisibility(false);
            hI();
            return true;
        }
        return false;
    }

    boolean bA(int i) {
        if (this.Ux == null || !this.Ux.onSuggestionSelect(i)) {
            bB(i);
            return true;
        }
        return false;
    }

    private void bB(int i) {
        Editable text = this.TZ.getText();
        Cursor cursor = this.UC.getCursor();
        if (cursor != null) {
            if (cursor.moveToPosition(i)) {
                CharSequence convertToString = this.UC.convertToString(cursor);
                if (convertToString != null) {
                    setQuery(convertToString);
                    return;
                } else {
                    setQuery(text);
                    return;
                }
            }
            setQuery(text);
        }
    }

    private boolean c(int i, int i2, String str) {
        Cursor cursor = this.UC.getCursor();
        if (cursor == null || !cursor.moveToPosition(i)) {
            return false;
        }
        z(a(cursor, i2, str));
        return true;
    }

    private void z(Intent intent) {
        if (intent != null) {
            try {
                getContext().startActivity(intent);
            } catch (RuntimeException e) {
                Log.e("SearchView", "Failed launch activity: " + intent, e);
            }
        }
    }

    private void setQuery(CharSequence charSequence) {
        this.TZ.setText(charSequence);
        this.TZ.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    void b(int i, String str, String str2) {
        getContext().startActivity(a("android.intent.action.SEARCH", (Uri) null, (String) null, str2, i, str));
    }

    private Intent a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.UJ);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.UN != null) {
            intent.putExtra("app_data", this.UN);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.UM.getSearchActivity());
        return intent;
    }

    private Intent a(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    private Intent b(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        if (this.UN != null) {
            bundle.putParcelable("app_data", this.UN);
        }
        Intent intent3 = new Intent(intent);
        String str = "free_form";
        int i = 1;
        Resources resources = getResources();
        if (searchableInfo.getVoiceLanguageModeId() != 0) {
            str = resources.getString(searchableInfo.getVoiceLanguageModeId());
        }
        String string = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string2 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        if (searchableInfo.getVoiceMaxResults() != 0) {
            i = searchableInfo.getVoiceMaxResults();
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", str);
        intent3.putExtra("android.speech.extra.PROMPT", string);
        intent3.putExtra("android.speech.extra.LANGUAGE", string2);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", i);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent a(Cursor cursor, int i, String str) {
        int i2;
        String a2;
        try {
            String a3 = r.a(cursor, "suggest_intent_action");
            if (a3 == null) {
                a3 = this.UM.getSuggestIntentAction();
            }
            if (a3 == null) {
                a3 = "android.intent.action.SEARCH";
            }
            String a4 = r.a(cursor, "suggest_intent_data");
            if (a4 == null) {
                a4 = this.UM.getSuggestIntentData();
            }
            if (a4 != null && (a2 = r.a(cursor, "suggest_intent_data_id")) != null) {
                a4 = a4 + "/" + Uri.encode(a2);
            }
            return a(a3, a4 == null ? null : Uri.parse(a4), r.a(cursor, "suggest_intent_extra_data"), r.a(cursor, "suggest_intent_query"), i, str);
        } catch (RuntimeException e) {
            try {
                i2 = cursor.getPosition();
            } catch (RuntimeException e2) {
                i2 = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + i2 + " returned exception.", e);
            return null;
        }
    }

    void hO() {
        UO.a(this.TZ);
        UO.b(this.TZ);
    }

    static boolean Y(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    /* loaded from: classes2.dex */
    private static class b extends TouchDelegate {
        private final View Ve;
        private final Rect Vf;
        private final Rect Vg;
        private final Rect Vh;
        private final int Vi;
        private boolean Vj;

        public b(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.Vi = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.Vf = new Rect();
            this.Vh = new Rect();
            this.Vg = new Rect();
            a(rect, rect2);
            this.Ve = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.Vf.set(rect);
            this.Vh.set(rect);
            this.Vh.inset(-this.Vi, -this.Vi);
            this.Vg.set(rect2);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z;
            boolean z2 = true;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.Vf.contains(x, y)) {
                        this.Vj = true;
                        z = true;
                        break;
                    }
                    z = false;
                    break;
                case 1:
                case 2:
                    z = this.Vj;
                    if (z && !this.Vh.contains(x, y)) {
                        z2 = false;
                        break;
                    }
                    break;
                case 3:
                    z = this.Vj;
                    this.Vj = false;
                    break;
                default:
                    z = false;
                    break;
            }
            if (z) {
                if (z2 && !this.Vg.contains(x, y)) {
                    motionEvent.setLocation(this.Ve.getWidth() / 2, this.Ve.getHeight() / 2);
                } else {
                    motionEvent.setLocation(x - this.Vg.left, y - this.Vg.top);
                }
                return this.Ve.dispatchTouchEvent(motionEvent);
            }
            return false;
        }
    }

    @RestrictTo
    /* loaded from: classes2.dex */
    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {
        private int Vc;
        private SearchView Vd;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.Vc = getThreshold();
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        void setSearchView(SearchView searchView) {
            this.Vd = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.Vc = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isEmpty() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence) {
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.Vd.hasFocus() && getVisibility() == 0) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                if (SearchView.Y(getContext())) {
                    SearchView.UO.a(this, true);
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.Vd.hM();
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.Vc <= 0 || super.enoughToFilter();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                        return true;
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.Vd.clearFocus();
                        this.Vd.setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int screenWidthDp = ConfigurationHelper.getScreenWidthDp(getResources());
            int screenHeightDp = ConfigurationHelper.getScreenHeightDp(getResources());
            if (screenWidthDp >= 960 && screenHeightDp >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (screenWidthDp >= 600 || (screenWidthDp >= 640 && screenHeightDp >= 480)) {
                return 192;
            }
            return 160;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private Method UX;
        private Method UY;
        private Method UZ;
        private Method Va;

        a() {
            try {
                this.UX = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.UX.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            try {
                this.UY = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.UY.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            try {
                this.UZ = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.UZ.setAccessible(true);
            } catch (NoSuchMethodException e3) {
            }
            try {
                this.Va = InputMethodManager.class.getMethod("showSoftInputUnchecked", Integer.TYPE, ResultReceiver.class);
                this.Va.setAccessible(true);
            } catch (NoSuchMethodException e4) {
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView) {
            if (this.UX != null) {
                try {
                    this.UX.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        void b(AutoCompleteTextView autoCompleteTextView) {
            if (this.UY != null) {
                try {
                    this.UY.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView, boolean z) {
            if (this.UZ != null) {
                try {
                    this.UZ.invoke(autoCompleteTextView, Boolean.valueOf(z));
                } catch (Exception e) {
                }
            }
        }

        void a(InputMethodManager inputMethodManager, View view, int i) {
            if (this.Va != null) {
                try {
                    this.Va.invoke(inputMethodManager, Integer.valueOf(i), null);
                    return;
                } catch (Exception e) {
                }
            }
            inputMethodManager.showSoftInput(view, i);
        }
    }
}
