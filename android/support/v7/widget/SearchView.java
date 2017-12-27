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
    static final a UQ = new a();
    private boolean UB;
    private boolean UC;
    CursorAdapter UD;
    private boolean UE;
    private CharSequence UF;
    private boolean UG;
    private boolean UH;
    private boolean UI;
    private CharSequence UJ;
    private CharSequence UK;
    private boolean UL;
    private int UM;
    SearchableInfo UN;
    private Bundle UO;
    private Runnable UR;
    private final Runnable US;
    private Runnable UT;
    private final WeakHashMap<String, Drawable.ConstantState> UU;
    View.OnKeyListener UV;
    private final TextView.OnEditorActionListener UW;
    final SearchAutoComplete Ua;
    private final View Ub;
    private final View Uc;
    private final View Ud;
    final ImageView Ue;
    final ImageView Uf;
    final ImageView Ug;
    final ImageView Uh;
    private final View Ui;
    private b Uj;
    private Rect Uk;
    private Rect Ul;
    private int[] Um;
    private int[] Un;
    private final ImageView Uo;
    private final Drawable Up;
    private final int Uq;
    private final int Ur;
    private final Intent Us;
    private final Intent Ut;
    private final CharSequence Uu;
    private OnQueryTextListener Uv;
    private OnCloseListener Uw;
    View.OnFocusChangeListener Ux;
    private OnSuggestionListener Uy;
    private View.OnClickListener Uz;
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
        this.Uk = new Rect();
        this.Ul = new Rect();
        this.Um = new int[2];
        this.Un = new int[2];
        this.UR = new Runnable() { // from class: android.support.v7.widget.SearchView.1
            @Override // java.lang.Runnable
            public void run() {
                InputMethodManager inputMethodManager = (InputMethodManager) SearchView.this.getContext().getSystemService("input_method");
                if (inputMethodManager != null) {
                    SearchView.UQ.a(inputMethodManager, SearchView.this, 0);
                }
            }
        };
        this.US = new Runnable() { // from class: android.support.v7.widget.SearchView.5
            @Override // java.lang.Runnable
            public void run() {
                SearchView.this.hE();
            }
        };
        this.UT = new Runnable() { // from class: android.support.v7.widget.SearchView.6
            @Override // java.lang.Runnable
            public void run() {
                if (SearchView.this.UD != null && (SearchView.this.UD instanceof r)) {
                    SearchView.this.UD.changeCursor(null);
                }
            }
        };
        this.UU = new WeakHashMap<>();
        this.mOnClickListener = new View.OnClickListener() { // from class: android.support.v7.widget.SearchView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == SearchView.this.Ue) {
                    SearchView.this.hK();
                } else if (view == SearchView.this.Ug) {
                    SearchView.this.hJ();
                } else if (view == SearchView.this.Uf) {
                    SearchView.this.hH();
                } else if (view == SearchView.this.Uh) {
                    SearchView.this.hL();
                } else if (view == SearchView.this.Ua) {
                    SearchView.this.hO();
                }
            }
        };
        this.UV = new View.OnKeyListener() { // from class: android.support.v7.widget.SearchView.11
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i2, KeyEvent keyEvent) {
                if (SearchView.this.UN == null) {
                    return false;
                }
                if (SearchView.this.Ua.isPopupShowing() && SearchView.this.Ua.getListSelection() != -1) {
                    return SearchView.this.a(view, i2, keyEvent);
                }
                if (!SearchView.this.Ua.isEmpty() && KeyEventCompat.hasNoModifiers(keyEvent) && keyEvent.getAction() == 1 && i2 == 66) {
                    view.cancelLongPress();
                    SearchView.this.b(0, (String) null, SearchView.this.Ua.getText().toString());
                    return true;
                }
                return false;
            }
        };
        this.UW = new TextView.OnEditorActionListener() { // from class: android.support.v7.widget.SearchView.12
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
        this.Ua = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.Ua.setSearchView(this);
        this.Ub = findViewById(R.id.search_edit_frame);
        this.Uc = findViewById(R.id.search_plate);
        this.Ud = findViewById(R.id.submit_area);
        this.Ue = (ImageView) findViewById(R.id.search_button);
        this.Uf = (ImageView) findViewById(R.id.search_go_btn);
        this.Ug = (ImageView) findViewById(R.id.search_close_btn);
        this.Uh = (ImageView) findViewById(R.id.search_voice_btn);
        this.Uo = (ImageView) findViewById(R.id.search_mag_icon);
        ViewCompat.setBackground(this.Uc, obtainStyledAttributes.getDrawable(R.styleable.SearchView_queryBackground));
        ViewCompat.setBackground(this.Ud, obtainStyledAttributes.getDrawable(R.styleable.SearchView_submitBackground));
        this.Ue.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_searchIcon));
        this.Uf.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_goIcon));
        this.Ug.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_closeIcon));
        this.Uh.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_voiceIcon));
        this.Uo.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_searchIcon));
        this.Up = obtainStyledAttributes.getDrawable(R.styleable.SearchView_searchHintIcon);
        this.Uq = obtainStyledAttributes.getResourceId(R.styleable.SearchView_suggestionRowLayout, R.layout.abc_search_dropdown_item_icons_2line);
        this.Ur = obtainStyledAttributes.getResourceId(R.styleable.SearchView_commitIcon, 0);
        this.Ue.setOnClickListener(this.mOnClickListener);
        this.Ug.setOnClickListener(this.mOnClickListener);
        this.Uf.setOnClickListener(this.mOnClickListener);
        this.Uh.setOnClickListener(this.mOnClickListener);
        this.Ua.setOnClickListener(this.mOnClickListener);
        this.Ua.addTextChangedListener(this.mTextWatcher);
        this.Ua.setOnEditorActionListener(this.UW);
        this.Ua.setOnItemClickListener(this.mOnItemClickListener);
        this.Ua.setOnItemSelectedListener(this.mOnItemSelectedListener);
        this.Ua.setOnKeyListener(this.UV);
        this.Ua.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: android.support.v7.widget.SearchView.7
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (SearchView.this.Ux != null) {
                    SearchView.this.Ux.onFocusChange(SearchView.this, z);
                }
            }
        });
        setIconifiedByDefault(obtainStyledAttributes.getBoolean(R.styleable.SearchView_iconifiedByDefault, true));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SearchView_android_maxWidth, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.Uu = obtainStyledAttributes.getText(R.styleable.SearchView_defaultQueryHint);
        this.UF = obtainStyledAttributes.getText(R.styleable.SearchView_queryHint);
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
        this.Us = new Intent("android.speech.action.WEB_SEARCH");
        this.Us.addFlags(268435456);
        this.Us.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.Ut = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.Ut.addFlags(268435456);
        this.Ui = findViewById(this.Ua.getDropDownAnchor());
        if (this.Ui != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                hx();
            } else {
                hy();
            }
        }
        J(this.UB);
        hF();
    }

    @TargetApi(11)
    private void hx() {
        this.Ui.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: android.support.v7.widget.SearchView.8
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                SearchView.this.hN();
            }
        });
    }

    private void hy() {
        this.Ui.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.widget.SearchView.9
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                SearchView.this.hN();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSuggestionRowLayout() {
        return this.Uq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSuggestionCommitIconResId() {
        return this.Ur;
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.UN = searchableInfo;
        if (this.UN != null) {
            hG();
            hF();
        }
        this.UI = hz();
        if (this.UI) {
            this.Ua.setPrivateImeOptions("nm");
        }
        J(isIconified());
    }

    @RestrictTo
    public void setAppSearchData(Bundle bundle) {
        this.UO = bundle;
    }

    public void setImeOptions(int i) {
        this.Ua.setImeOptions(i);
    }

    public int getImeOptions() {
        return this.Ua.getImeOptions();
    }

    public void setInputType(int i) {
        this.Ua.setInputType(i);
    }

    public int getInputType() {
        return this.Ua.getInputType();
    }

    @Override // android.view.ViewGroup, android.view.View
    @RestrictTo
    public boolean requestFocus(int i, Rect rect) {
        if (!this.UH && isFocusable()) {
            if (!isIconified()) {
                boolean requestFocus = this.Ua.requestFocus(i, rect);
                if (requestFocus) {
                    J(false);
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
        this.UH = true;
        setImeVisibility(false);
        super.clearFocus();
        this.Ua.clearFocus();
        this.UH = false;
    }

    public void setOnQueryTextListener(OnQueryTextListener onQueryTextListener) {
        this.Uv = onQueryTextListener;
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.Uw = onCloseListener;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.Ux = onFocusChangeListener;
    }

    public void setOnSuggestionListener(OnSuggestionListener onSuggestionListener) {
        this.Uy = onSuggestionListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.Uz = onClickListener;
    }

    public CharSequence getQuery() {
        return this.Ua.getText();
    }

    public void setQuery(CharSequence charSequence, boolean z) {
        this.Ua.setText(charSequence);
        if (charSequence != null) {
            this.Ua.setSelection(this.Ua.length());
            this.UK = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            hH();
        }
    }

    public void setQueryHint(CharSequence charSequence) {
        this.UF = charSequence;
        hF();
    }

    public CharSequence getQueryHint() {
        if (this.UF != null) {
            return this.UF;
        }
        if (this.UN != null && this.UN.getHintId() != 0) {
            return getContext().getText(this.UN.getHintId());
        }
        return this.Uu;
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.UB != z) {
            this.UB = z;
            J(z);
            hF();
        }
    }

    public boolean isIconfiedByDefault() {
        return this.UB;
    }

    public void setIconified(boolean z) {
        if (z) {
            hJ();
        } else {
            hK();
        }
    }

    public boolean isIconified() {
        return this.UC;
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.UE = z;
        J(isIconified());
    }

    public boolean isSubmitButtonEnabled() {
        return this.UE;
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.UG = z;
        if (this.UD instanceof r) {
            ((r) this.UD).ce(z ? 2 : 1);
        }
    }

    public boolean isQueryRefinementEnabled() {
        return this.UG;
    }

    public void setSuggestionsAdapter(CursorAdapter cursorAdapter) {
        this.UD = cursorAdapter;
        this.Ua.setAdapter(this.UD);
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.UD;
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
            e(this.Ua, this.Uk);
            this.Ul.set(this.Uk.left, 0, this.Uk.right, i4 - i2);
            if (this.Uj == null) {
                this.Uj = new b(this.Ul, this.Uk, this.Ua);
                setTouchDelegate(this.Uj);
                return;
            }
            this.Uj.a(this.Ul, this.Uk);
        }
    }

    private void e(View view, Rect rect) {
        view.getLocationInWindow(this.Um);
        getLocationInWindow(this.Un);
        int i = this.Um[1] - this.Un[1];
        int i2 = this.Um[0] - this.Un[0];
        rect.set(i2, i, view.getWidth() + i2, view.getHeight() + i);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    private void J(boolean z) {
        int i = 8;
        this.UC = z;
        int i2 = z ? 0 : 8;
        boolean z2 = !TextUtils.isEmpty(this.Ua.getText());
        this.Ue.setVisibility(i2);
        K(z2);
        this.Ub.setVisibility(z ? 8 : 0);
        if (this.Uo.getDrawable() != null && !this.UB) {
            i = 0;
        }
        this.Uo.setVisibility(i);
        hC();
        L(z2 ? false : true);
        hB();
    }

    private boolean hz() {
        if (this.UN == null || !this.UN.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.UN.getVoiceSearchLaunchWebSearch()) {
            intent = this.Us;
        } else if (this.UN.getVoiceSearchLaunchRecognizer()) {
            intent = this.Ut;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    private boolean hA() {
        return (this.UE || this.UI) && !isIconified();
    }

    private void K(boolean z) {
        int i = 8;
        if (this.UE && hA() && hasFocus() && (z || !this.UI)) {
            i = 0;
        }
        this.Uf.setVisibility(i);
    }

    private void hB() {
        int i = 8;
        if (hA() && (this.Uf.getVisibility() == 0 || this.Uh.getVisibility() == 0)) {
            i = 0;
        }
        this.Ud.setVisibility(i);
    }

    private void hC() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.Ua.getText());
        if (!z2 && (!this.UB || this.UL)) {
            z = false;
        }
        this.Ug.setVisibility(z ? 0 : 8);
        Drawable drawable = this.Ug.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void hD() {
        post(this.US);
    }

    void hE() {
        int[] iArr = this.Ua.hasFocus() ? FOCUSED_STATE_SET : EMPTY_STATE_SET;
        Drawable background = this.Uc.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.Ud.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.US);
        post(this.UT);
        super.onDetachedFromWindow();
    }

    void setImeVisibility(boolean z) {
        if (z) {
            post(this.UR);
            return;
        }
        removeCallbacks(this.UR);
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
        if (this.UN != null && this.UD != null && keyEvent.getAction() == 0 && KeyEventCompat.hasNoModifiers(keyEvent)) {
            if (i == 66 || i == 84 || i == 61) {
                return b(this.Ua.getListSelection(), 0, (String) null);
            }
            if (i == 21 || i == 22) {
                this.Ua.setSelection(i == 21 ? 0 : this.Ua.length());
                this.Ua.setListSelection(0);
                this.Ua.clearListSelection();
                UQ.a(this.Ua, true);
                return true;
            }
            if (i != 19 || this.Ua.getListSelection() != 0) {
            }
            return false;
        }
        return false;
    }

    private CharSequence i(CharSequence charSequence) {
        if (this.UB && this.Up != null) {
            int textSize = (int) (this.Ua.getTextSize() * 1.25d);
            this.Up.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(this.Up), 1, 2, 33);
            spannableStringBuilder.append(charSequence);
            return spannableStringBuilder;
        }
        return charSequence;
    }

    private void hF() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.Ua;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(i(queryHint));
    }

    private void hG() {
        this.Ua.setThreshold(this.UN.getSuggestThreshold());
        this.Ua.setImeOptions(this.UN.getImeOptions());
        int inputType = this.UN.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.UN.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.Ua.setInputType(inputType);
        if (this.UD != null) {
            this.UD.changeCursor(null);
        }
        if (this.UN.getSuggestAuthority() != null) {
            this.UD = new r(getContext(), this, this.UN, this.UU);
            this.Ua.setAdapter(this.UD);
            ((r) this.UD).ce(this.UG ? 2 : 1);
        }
    }

    private void L(boolean z) {
        int i;
        if (this.UI && !isIconified() && z) {
            i = 0;
            this.Uf.setVisibility(8);
        } else {
            i = 8;
        }
        this.Uh.setVisibility(i);
    }

    void j(CharSequence charSequence) {
        Editable text = this.Ua.getText();
        this.UK = text;
        boolean z = !TextUtils.isEmpty(text);
        K(z);
        L(z ? false : true);
        hC();
        hB();
        if (this.Uv != null && !TextUtils.equals(charSequence, this.UJ)) {
            this.Uv.onQueryTextChange(charSequence.toString());
        }
        this.UJ = charSequence.toString();
    }

    void hH() {
        Editable text = this.Ua.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.Uv == null || !this.Uv.onQueryTextSubmit(text.toString())) {
                if (this.UN != null) {
                    b(0, (String) null, text.toString());
                }
                setImeVisibility(false);
                hI();
            }
        }
    }

    private void hI() {
        this.Ua.dismissDropDown();
    }

    void hJ() {
        if (TextUtils.isEmpty(this.Ua.getText())) {
            if (this.UB) {
                if (this.Uw == null || !this.Uw.onClose()) {
                    clearFocus();
                    J(true);
                    return;
                }
                return;
            }
            return;
        }
        this.Ua.setText("");
        this.Ua.requestFocus();
        setImeVisibility(true);
    }

    void hK() {
        J(false);
        this.Ua.requestFocus();
        setImeVisibility(true);
        if (this.Uz != null) {
            this.Uz.onClick(this);
        }
    }

    void hL() {
        if (this.UN != null) {
            SearchableInfo searchableInfo = this.UN;
            try {
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    getContext().startActivity(a(this.Us, searchableInfo));
                } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    getContext().startActivity(b(this.Ut, searchableInfo));
                }
            } catch (ActivityNotFoundException e) {
                Log.w("SearchView", "Could not find voice search activity");
            }
        }
    }

    void hM() {
        J(isIconified());
        hD();
        if (this.Ua.hasFocus()) {
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
        J(true);
        this.Ua.setImeOptions(this.UM);
        this.UL = false;
    }

    @Override // android.support.v7.view.CollapsibleActionView
    public void onActionViewExpanded() {
        if (!this.UL) {
            this.UL = true;
            this.UM = this.Ua.getImeOptions();
            this.Ua.setImeOptions(this.UM | 33554432);
            this.Ua.setText("");
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
        boolean Vc;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.Vc = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.Vc));
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.Vc + "}";
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Vc = isIconified();
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
        J(savedState.Vc);
        requestLayout();
    }

    void hN() {
        int i;
        int i2;
        if (this.Ui.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.Uc.getPaddingLeft();
            Rect rect = new Rect();
            boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
            if (this.UB) {
                i = resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width);
            } else {
                i = 0;
            }
            this.Ua.getDropDownBackground().getPadding(rect);
            if (isLayoutRtl) {
                i2 = -rect.left;
            } else {
                i2 = paddingLeft - (rect.left + i);
            }
            this.Ua.setDropDownHorizontalOffset(i2);
            this.Ua.setDropDownWidth((i + ((this.Ui.getWidth() + rect.left) + rect.right)) - paddingLeft);
        }
    }

    boolean b(int i, int i2, String str) {
        if (this.Uy == null || !this.Uy.onSuggestionClick(i)) {
            c(i, 0, null);
            setImeVisibility(false);
            hI();
            return true;
        }
        return false;
    }

    boolean bA(int i) {
        if (this.Uy == null || !this.Uy.onSuggestionSelect(i)) {
            bB(i);
            return true;
        }
        return false;
    }

    private void bB(int i) {
        Editable text = this.Ua.getText();
        Cursor cursor = this.UD.getCursor();
        if (cursor != null) {
            if (cursor.moveToPosition(i)) {
                CharSequence convertToString = this.UD.convertToString(cursor);
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
        Cursor cursor = this.UD.getCursor();
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
        this.Ua.setText(charSequence);
        this.Ua.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
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
        intent.putExtra("user_query", this.UK);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.UO != null) {
            intent.putExtra("app_data", this.UO);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.UN.getSearchActivity());
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
        if (this.UO != null) {
            bundle.putParcelable("app_data", this.UO);
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
                a3 = this.UN.getSuggestIntentAction();
            }
            if (a3 == null) {
                a3 = "android.intent.action.SEARCH";
            }
            String a4 = r.a(cursor, "suggest_intent_data");
            if (a4 == null) {
                a4 = this.UN.getSuggestIntentData();
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
        UQ.a(this.Ua);
        UQ.b(this.Ua);
    }

    static boolean Y(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    /* loaded from: classes2.dex */
    private static class b extends TouchDelegate {
        private final View Vf;
        private final Rect Vg;
        private final Rect Vh;
        private final Rect Vi;
        private final int Vj;
        private boolean Vk;

        public b(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.Vj = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.Vg = new Rect();
            this.Vi = new Rect();
            this.Vh = new Rect();
            a(rect, rect2);
            this.Vf = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.Vg.set(rect);
            this.Vi.set(rect);
            this.Vi.inset(-this.Vj, -this.Vj);
            this.Vh.set(rect2);
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
                    if (this.Vg.contains(x, y)) {
                        this.Vk = true;
                        z = true;
                        break;
                    }
                    z = false;
                    break;
                case 1:
                case 2:
                    z = this.Vk;
                    if (z && !this.Vi.contains(x, y)) {
                        z2 = false;
                        break;
                    }
                    break;
                case 3:
                    z = this.Vk;
                    this.Vk = false;
                    break;
                default:
                    z = false;
                    break;
            }
            if (z) {
                if (z2 && !this.Vh.contains(x, y)) {
                    motionEvent.setLocation(this.Vf.getWidth() / 2, this.Vf.getHeight() / 2);
                } else {
                    motionEvent.setLocation(x - this.Vh.left, y - this.Vh.top);
                }
                return this.Vf.dispatchTouchEvent(motionEvent);
            }
            return false;
        }
    }

    @RestrictTo
    /* loaded from: classes2.dex */
    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {
        private int Vd;
        private SearchView Ve;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.Vd = getThreshold();
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        void setSearchView(SearchView searchView) {
            this.Ve = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.Vd = i;
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
            if (z && this.Ve.hasFocus() && getVisibility() == 0) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                if (SearchView.Y(getContext())) {
                    SearchView.UQ.a(this, true);
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.Ve.hM();
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.Vd <= 0 || super.enoughToFilter();
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
                        this.Ve.clearFocus();
                        this.Ve.setImeVisibility(false);
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
        private Method UY;
        private Method UZ;
        private Method Va;
        private Method Vb;

        a() {
            try {
                this.UY = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.UY.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            try {
                this.UZ = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.UZ.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            try {
                this.Va = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.Va.setAccessible(true);
            } catch (NoSuchMethodException e3) {
            }
            try {
                this.Vb = InputMethodManager.class.getMethod("showSoftInputUnchecked", Integer.TYPE, ResultReceiver.class);
                this.Vb.setAccessible(true);
            } catch (NoSuchMethodException e4) {
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView) {
            if (this.UY != null) {
                try {
                    this.UY.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        void b(AutoCompleteTextView autoCompleteTextView) {
            if (this.UZ != null) {
                try {
                    this.UZ.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView, boolean z) {
            if (this.Va != null) {
                try {
                    this.Va.invoke(autoCompleteTextView, Boolean.valueOf(z));
                } catch (Exception e) {
                }
            }
        }

        void a(InputMethodManager inputMethodManager, View view, int i) {
            if (this.Vb != null) {
                try {
                    this.Vb.invoke(inputMethodManager, Integer.valueOf(i), null);
                    return;
                } catch (Exception e) {
                }
            }
            inputMethodManager.showSoftInput(view, i);
        }
    }
}
