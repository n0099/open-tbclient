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
    static final a UI = new a();
    final SearchAutoComplete TT;
    private final View TU;
    private final View TV;
    private final View TW;
    final ImageView TX;
    final ImageView TY;
    final ImageView TZ;
    private boolean UB;
    private CharSequence UC;
    private CharSequence UD;
    private boolean UE;
    private int UF;
    SearchableInfo UG;
    private Bundle UH;
    private Runnable UJ;
    private final Runnable UK;
    private Runnable UL;
    private final WeakHashMap<String, Drawable.ConstantState> UM;
    View.OnKeyListener UN;
    private final TextView.OnEditorActionListener UO;
    final ImageView Ua;
    private final View Ub;
    private b Uc;
    private Rect Ud;
    private Rect Ue;
    private int[] Uf;
    private int[] Ug;
    private final ImageView Uh;
    private final Drawable Ui;
    private final int Uj;
    private final int Uk;
    private final Intent Ul;
    private final Intent Um;
    private final CharSequence Un;
    private OnQueryTextListener Uo;
    private OnCloseListener Up;
    View.OnFocusChangeListener Uq;
    private OnSuggestionListener Ur;
    private View.OnClickListener Us;
    private boolean Ut;
    private boolean Uu;
    CursorAdapter Uv;
    private boolean Uw;
    private CharSequence Ux;
    private boolean Uy;
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
        this.Ud = new Rect();
        this.Ue = new Rect();
        this.Uf = new int[2];
        this.Ug = new int[2];
        this.UJ = new Runnable() { // from class: android.support.v7.widget.SearchView.1
            @Override // java.lang.Runnable
            public void run() {
                InputMethodManager inputMethodManager = (InputMethodManager) SearchView.this.getContext().getSystemService("input_method");
                if (inputMethodManager != null) {
                    SearchView.UI.a(inputMethodManager, SearchView.this, 0);
                }
            }
        };
        this.UK = new Runnable() { // from class: android.support.v7.widget.SearchView.5
            @Override // java.lang.Runnable
            public void run() {
                SearchView.this.hE();
            }
        };
        this.UL = new Runnable() { // from class: android.support.v7.widget.SearchView.6
            @Override // java.lang.Runnable
            public void run() {
                if (SearchView.this.Uv != null && (SearchView.this.Uv instanceof r)) {
                    SearchView.this.Uv.changeCursor(null);
                }
            }
        };
        this.UM = new WeakHashMap<>();
        this.mOnClickListener = new View.OnClickListener() { // from class: android.support.v7.widget.SearchView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == SearchView.this.TX) {
                    SearchView.this.hK();
                } else if (view == SearchView.this.TZ) {
                    SearchView.this.hJ();
                } else if (view == SearchView.this.TY) {
                    SearchView.this.hH();
                } else if (view == SearchView.this.Ua) {
                    SearchView.this.hL();
                } else if (view == SearchView.this.TT) {
                    SearchView.this.hO();
                }
            }
        };
        this.UN = new View.OnKeyListener() { // from class: android.support.v7.widget.SearchView.11
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i2, KeyEvent keyEvent) {
                if (SearchView.this.UG == null) {
                    return false;
                }
                if (SearchView.this.TT.isPopupShowing() && SearchView.this.TT.getListSelection() != -1) {
                    return SearchView.this.a(view, i2, keyEvent);
                }
                if (!SearchView.this.TT.isEmpty() && KeyEventCompat.hasNoModifiers(keyEvent) && keyEvent.getAction() == 1 && i2 == 66) {
                    view.cancelLongPress();
                    SearchView.this.b(0, (String) null, SearchView.this.TT.getText().toString());
                    return true;
                }
                return false;
            }
        };
        this.UO = new TextView.OnEditorActionListener() { // from class: android.support.v7.widget.SearchView.12
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
        this.TT = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.TT.setSearchView(this);
        this.TU = findViewById(R.id.search_edit_frame);
        this.TV = findViewById(R.id.search_plate);
        this.TW = findViewById(R.id.submit_area);
        this.TX = (ImageView) findViewById(R.id.search_button);
        this.TY = (ImageView) findViewById(R.id.search_go_btn);
        this.TZ = (ImageView) findViewById(R.id.search_close_btn);
        this.Ua = (ImageView) findViewById(R.id.search_voice_btn);
        this.Uh = (ImageView) findViewById(R.id.search_mag_icon);
        ViewCompat.setBackground(this.TV, obtainStyledAttributes.getDrawable(R.styleable.SearchView_queryBackground));
        ViewCompat.setBackground(this.TW, obtainStyledAttributes.getDrawable(R.styleable.SearchView_submitBackground));
        this.TX.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_searchIcon));
        this.TY.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_goIcon));
        this.TZ.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_closeIcon));
        this.Ua.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_voiceIcon));
        this.Uh.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.SearchView_searchIcon));
        this.Ui = obtainStyledAttributes.getDrawable(R.styleable.SearchView_searchHintIcon);
        this.Uj = obtainStyledAttributes.getResourceId(R.styleable.SearchView_suggestionRowLayout, R.layout.abc_search_dropdown_item_icons_2line);
        this.Uk = obtainStyledAttributes.getResourceId(R.styleable.SearchView_commitIcon, 0);
        this.TX.setOnClickListener(this.mOnClickListener);
        this.TZ.setOnClickListener(this.mOnClickListener);
        this.TY.setOnClickListener(this.mOnClickListener);
        this.Ua.setOnClickListener(this.mOnClickListener);
        this.TT.setOnClickListener(this.mOnClickListener);
        this.TT.addTextChangedListener(this.mTextWatcher);
        this.TT.setOnEditorActionListener(this.UO);
        this.TT.setOnItemClickListener(this.mOnItemClickListener);
        this.TT.setOnItemSelectedListener(this.mOnItemSelectedListener);
        this.TT.setOnKeyListener(this.UN);
        this.TT.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: android.support.v7.widget.SearchView.7
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (SearchView.this.Uq != null) {
                    SearchView.this.Uq.onFocusChange(SearchView.this, z);
                }
            }
        });
        setIconifiedByDefault(obtainStyledAttributes.getBoolean(R.styleable.SearchView_iconifiedByDefault, true));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SearchView_android_maxWidth, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.Un = obtainStyledAttributes.getText(R.styleable.SearchView_defaultQueryHint);
        this.Ux = obtainStyledAttributes.getText(R.styleable.SearchView_queryHint);
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
        this.Ul = new Intent("android.speech.action.WEB_SEARCH");
        this.Ul.addFlags(268435456);
        this.Ul.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.Um = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.Um.addFlags(268435456);
        this.Ub = findViewById(this.TT.getDropDownAnchor());
        if (this.Ub != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                hx();
            } else {
                hy();
            }
        }
        L(this.Ut);
        hF();
    }

    @TargetApi(11)
    private void hx() {
        this.Ub.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: android.support.v7.widget.SearchView.8
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                SearchView.this.hN();
            }
        });
    }

    private void hy() {
        this.Ub.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.widget.SearchView.9
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                SearchView.this.hN();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSuggestionRowLayout() {
        return this.Uj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSuggestionCommitIconResId() {
        return this.Uk;
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.UG = searchableInfo;
        if (this.UG != null) {
            hG();
            hF();
        }
        this.UB = hz();
        if (this.UB) {
            this.TT.setPrivateImeOptions("nm");
        }
        L(isIconified());
    }

    @RestrictTo
    public void setAppSearchData(Bundle bundle) {
        this.UH = bundle;
    }

    public void setImeOptions(int i) {
        this.TT.setImeOptions(i);
    }

    public int getImeOptions() {
        return this.TT.getImeOptions();
    }

    public void setInputType(int i) {
        this.TT.setInputType(i);
    }

    public int getInputType() {
        return this.TT.getInputType();
    }

    @Override // android.view.ViewGroup, android.view.View
    @RestrictTo
    public boolean requestFocus(int i, Rect rect) {
        if (!this.Uz && isFocusable()) {
            if (!isIconified()) {
                boolean requestFocus = this.TT.requestFocus(i, rect);
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
        this.Uz = true;
        setImeVisibility(false);
        super.clearFocus();
        this.TT.clearFocus();
        this.Uz = false;
    }

    public void setOnQueryTextListener(OnQueryTextListener onQueryTextListener) {
        this.Uo = onQueryTextListener;
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.Up = onCloseListener;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.Uq = onFocusChangeListener;
    }

    public void setOnSuggestionListener(OnSuggestionListener onSuggestionListener) {
        this.Ur = onSuggestionListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.Us = onClickListener;
    }

    public CharSequence getQuery() {
        return this.TT.getText();
    }

    public void setQuery(CharSequence charSequence, boolean z) {
        this.TT.setText(charSequence);
        if (charSequence != null) {
            this.TT.setSelection(this.TT.length());
            this.UD = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            hH();
        }
    }

    public void setQueryHint(CharSequence charSequence) {
        this.Ux = charSequence;
        hF();
    }

    public CharSequence getQueryHint() {
        if (this.Ux != null) {
            return this.Ux;
        }
        if (this.UG != null && this.UG.getHintId() != 0) {
            return getContext().getText(this.UG.getHintId());
        }
        return this.Un;
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.Ut != z) {
            this.Ut = z;
            L(z);
            hF();
        }
    }

    public boolean isIconfiedByDefault() {
        return this.Ut;
    }

    public void setIconified(boolean z) {
        if (z) {
            hJ();
        } else {
            hK();
        }
    }

    public boolean isIconified() {
        return this.Uu;
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.Uw = z;
        L(isIconified());
    }

    public boolean isSubmitButtonEnabled() {
        return this.Uw;
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.Uy = z;
        if (this.Uv instanceof r) {
            ((r) this.Uv).ce(z ? 2 : 1);
        }
    }

    public boolean isQueryRefinementEnabled() {
        return this.Uy;
    }

    public void setSuggestionsAdapter(CursorAdapter cursorAdapter) {
        this.Uv = cursorAdapter;
        this.TT.setAdapter(this.Uv);
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.Uv;
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
            e(this.TT, this.Ud);
            this.Ue.set(this.Ud.left, 0, this.Ud.right, i4 - i2);
            if (this.Uc == null) {
                this.Uc = new b(this.Ue, this.Ud, this.TT);
                setTouchDelegate(this.Uc);
                return;
            }
            this.Uc.a(this.Ue, this.Ud);
        }
    }

    private void e(View view, Rect rect) {
        view.getLocationInWindow(this.Uf);
        getLocationInWindow(this.Ug);
        int i = this.Uf[1] - this.Ug[1];
        int i2 = this.Uf[0] - this.Ug[0];
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
        this.Uu = z;
        int i2 = z ? 0 : 8;
        boolean z2 = !TextUtils.isEmpty(this.TT.getText());
        this.TX.setVisibility(i2);
        M(z2);
        this.TU.setVisibility(z ? 8 : 0);
        if (this.Uh.getDrawable() != null && !this.Ut) {
            i = 0;
        }
        this.Uh.setVisibility(i);
        hC();
        N(z2 ? false : true);
        hB();
    }

    private boolean hz() {
        if (this.UG == null || !this.UG.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.UG.getVoiceSearchLaunchWebSearch()) {
            intent = this.Ul;
        } else if (this.UG.getVoiceSearchLaunchRecognizer()) {
            intent = this.Um;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    private boolean hA() {
        return (this.Uw || this.UB) && !isIconified();
    }

    private void M(boolean z) {
        int i = 8;
        if (this.Uw && hA() && hasFocus() && (z || !this.UB)) {
            i = 0;
        }
        this.TY.setVisibility(i);
    }

    private void hB() {
        int i = 8;
        if (hA() && (this.TY.getVisibility() == 0 || this.Ua.getVisibility() == 0)) {
            i = 0;
        }
        this.TW.setVisibility(i);
    }

    private void hC() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.TT.getText());
        if (!z2 && (!this.Ut || this.UE)) {
            z = false;
        }
        this.TZ.setVisibility(z ? 0 : 8);
        Drawable drawable = this.TZ.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void hD() {
        post(this.UK);
    }

    void hE() {
        int[] iArr = this.TT.hasFocus() ? FOCUSED_STATE_SET : EMPTY_STATE_SET;
        Drawable background = this.TV.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.TW.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.UK);
        post(this.UL);
        super.onDetachedFromWindow();
    }

    void setImeVisibility(boolean z) {
        if (z) {
            post(this.UJ);
            return;
        }
        removeCallbacks(this.UJ);
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
        if (this.UG != null && this.Uv != null && keyEvent.getAction() == 0 && KeyEventCompat.hasNoModifiers(keyEvent)) {
            if (i == 66 || i == 84 || i == 61) {
                return b(this.TT.getListSelection(), 0, (String) null);
            }
            if (i == 21 || i == 22) {
                this.TT.setSelection(i == 21 ? 0 : this.TT.length());
                this.TT.setListSelection(0);
                this.TT.clearListSelection();
                UI.a(this.TT, true);
                return true;
            }
            if (i != 19 || this.TT.getListSelection() != 0) {
            }
            return false;
        }
        return false;
    }

    private CharSequence i(CharSequence charSequence) {
        if (this.Ut && this.Ui != null) {
            int textSize = (int) (this.TT.getTextSize() * 1.25d);
            this.Ui.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(this.Ui), 1, 2, 33);
            spannableStringBuilder.append(charSequence);
            return spannableStringBuilder;
        }
        return charSequence;
    }

    private void hF() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.TT;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(i(queryHint));
    }

    private void hG() {
        this.TT.setThreshold(this.UG.getSuggestThreshold());
        this.TT.setImeOptions(this.UG.getImeOptions());
        int inputType = this.UG.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.UG.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.TT.setInputType(inputType);
        if (this.Uv != null) {
            this.Uv.changeCursor(null);
        }
        if (this.UG.getSuggestAuthority() != null) {
            this.Uv = new r(getContext(), this, this.UG, this.UM);
            this.TT.setAdapter(this.Uv);
            ((r) this.Uv).ce(this.Uy ? 2 : 1);
        }
    }

    private void N(boolean z) {
        int i;
        if (this.UB && !isIconified() && z) {
            i = 0;
            this.TY.setVisibility(8);
        } else {
            i = 8;
        }
        this.Ua.setVisibility(i);
    }

    void j(CharSequence charSequence) {
        Editable text = this.TT.getText();
        this.UD = text;
        boolean z = !TextUtils.isEmpty(text);
        M(z);
        N(z ? false : true);
        hC();
        hB();
        if (this.Uo != null && !TextUtils.equals(charSequence, this.UC)) {
            this.Uo.onQueryTextChange(charSequence.toString());
        }
        this.UC = charSequence.toString();
    }

    void hH() {
        Editable text = this.TT.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.Uo == null || !this.Uo.onQueryTextSubmit(text.toString())) {
                if (this.UG != null) {
                    b(0, (String) null, text.toString());
                }
                setImeVisibility(false);
                hI();
            }
        }
    }

    private void hI() {
        this.TT.dismissDropDown();
    }

    void hJ() {
        if (TextUtils.isEmpty(this.TT.getText())) {
            if (this.Ut) {
                if (this.Up == null || !this.Up.onClose()) {
                    clearFocus();
                    L(true);
                    return;
                }
                return;
            }
            return;
        }
        this.TT.setText("");
        this.TT.requestFocus();
        setImeVisibility(true);
    }

    void hK() {
        L(false);
        this.TT.requestFocus();
        setImeVisibility(true);
        if (this.Us != null) {
            this.Us.onClick(this);
        }
    }

    void hL() {
        if (this.UG != null) {
            SearchableInfo searchableInfo = this.UG;
            try {
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    getContext().startActivity(a(this.Ul, searchableInfo));
                } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    getContext().startActivity(b(this.Um, searchableInfo));
                }
            } catch (ActivityNotFoundException e) {
                Log.w("SearchView", "Could not find voice search activity");
            }
        }
    }

    void hM() {
        L(isIconified());
        hD();
        if (this.TT.hasFocus()) {
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
        this.TT.setImeOptions(this.UF);
        this.UE = false;
    }

    @Override // android.support.v7.view.CollapsibleActionView
    public void onActionViewExpanded() {
        if (!this.UE) {
            this.UE = true;
            this.UF = this.TT.getImeOptions();
            this.TT.setImeOptions(this.UF | 33554432);
            this.TT.setText("");
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
        boolean UV;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.UV = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.UV));
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.UV + "}";
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.UV = isIconified();
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
        L(savedState.UV);
        requestLayout();
    }

    void hN() {
        int i;
        int i2;
        if (this.Ub.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.TV.getPaddingLeft();
            Rect rect = new Rect();
            boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
            if (this.Ut) {
                i = resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width);
            } else {
                i = 0;
            }
            this.TT.getDropDownBackground().getPadding(rect);
            if (isLayoutRtl) {
                i2 = -rect.left;
            } else {
                i2 = paddingLeft - (rect.left + i);
            }
            this.TT.setDropDownHorizontalOffset(i2);
            this.TT.setDropDownWidth((i + ((this.Ub.getWidth() + rect.left) + rect.right)) - paddingLeft);
        }
    }

    boolean b(int i, int i2, String str) {
        if (this.Ur == null || !this.Ur.onSuggestionClick(i)) {
            c(i, 0, null);
            setImeVisibility(false);
            hI();
            return true;
        }
        return false;
    }

    boolean bA(int i) {
        if (this.Ur == null || !this.Ur.onSuggestionSelect(i)) {
            bB(i);
            return true;
        }
        return false;
    }

    private void bB(int i) {
        Editable text = this.TT.getText();
        Cursor cursor = this.Uv.getCursor();
        if (cursor != null) {
            if (cursor.moveToPosition(i)) {
                CharSequence convertToString = this.Uv.convertToString(cursor);
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
        Cursor cursor = this.Uv.getCursor();
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
        this.TT.setText(charSequence);
        this.TT.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
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
        intent.putExtra("user_query", this.UD);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.UH != null) {
            intent.putExtra("app_data", this.UH);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.UG.getSearchActivity());
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
        if (this.UH != null) {
            bundle.putParcelable("app_data", this.UH);
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
                a3 = this.UG.getSuggestIntentAction();
            }
            if (a3 == null) {
                a3 = "android.intent.action.SEARCH";
            }
            String a4 = r.a(cursor, "suggest_intent_data");
            if (a4 == null) {
                a4 = this.UG.getSuggestIntentData();
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
        UI.a(this.TT);
        UI.b(this.TT);
    }

    static boolean Y(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    /* loaded from: classes2.dex */
    private static class b extends TouchDelegate {
        private final View UY;
        private final Rect UZ;
        private final Rect Va;
        private final Rect Vb;
        private final int Vc;
        private boolean Vd;

        public b(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.Vc = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.UZ = new Rect();
            this.Vb = new Rect();
            this.Va = new Rect();
            a(rect, rect2);
            this.UY = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.UZ.set(rect);
            this.Vb.set(rect);
            this.Vb.inset(-this.Vc, -this.Vc);
            this.Va.set(rect2);
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
                    if (this.UZ.contains(x, y)) {
                        this.Vd = true;
                        z = true;
                        break;
                    }
                    z = false;
                    break;
                case 1:
                case 2:
                    z = this.Vd;
                    if (z && !this.Vb.contains(x, y)) {
                        z2 = false;
                        break;
                    }
                    break;
                case 3:
                    z = this.Vd;
                    this.Vd = false;
                    break;
                default:
                    z = false;
                    break;
            }
            if (z) {
                if (z2 && !this.Va.contains(x, y)) {
                    motionEvent.setLocation(this.UY.getWidth() / 2, this.UY.getHeight() / 2);
                } else {
                    motionEvent.setLocation(x - this.Va.left, y - this.Va.top);
                }
                return this.UY.dispatchTouchEvent(motionEvent);
            }
            return false;
        }
    }

    @RestrictTo
    /* loaded from: classes2.dex */
    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {
        private int UW;
        private SearchView UX;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.UW = getThreshold();
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        void setSearchView(SearchView searchView) {
            this.UX = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.UW = i;
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
            if (z && this.UX.hasFocus() && getVisibility() == 0) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                if (SearchView.Y(getContext())) {
                    SearchView.UI.a(this, true);
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.UX.hM();
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.UW <= 0 || super.enoughToFilter();
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
                        this.UX.clearFocus();
                        this.UX.setImeVisibility(false);
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
        private Method UR;
        private Method US;
        private Method UT;
        private Method UU;

        a() {
            try {
                this.UR = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.UR.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            try {
                this.US = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.US.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            try {
                this.UT = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.UT.setAccessible(true);
            } catch (NoSuchMethodException e3) {
            }
            try {
                this.UU = InputMethodManager.class.getMethod("showSoftInputUnchecked", Integer.TYPE, ResultReceiver.class);
                this.UU.setAccessible(true);
            } catch (NoSuchMethodException e4) {
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView) {
            if (this.UR != null) {
                try {
                    this.UR.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        void b(AutoCompleteTextView autoCompleteTextView) {
            if (this.US != null) {
                try {
                    this.US.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView, boolean z) {
            if (this.UT != null) {
                try {
                    this.UT.invoke(autoCompleteTextView, Boolean.valueOf(z));
                } catch (Exception e) {
                }
            }
        }

        void a(InputMethodManager inputMethodManager, View view, int i) {
            if (this.UU != null) {
                try {
                    this.UU.invoke(inputMethodManager, Integer.valueOf(i), null);
                    return;
                } catch (Exception e) {
                }
            }
            inputMethodManager.showSoftInput(view, i);
        }
    }
}
