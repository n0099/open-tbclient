package com.baidu.live.feed.search.view;

import android.content.Context;
import android.os.Message;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.ca0;
import com.baidu.tieba.tc0;
import com.baidu.tieba.va0;
import com.baidu.tieba.wa0;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 m2\u00020\u00012\u00020\u0002:\u0002mnB)\b\u0007\u0012\b\u0010f\u001a\u0004\u0018\u00010e\u0012\n\b\u0002\u0010h\u001a\u0004\u0018\u00010g\u0012\b\b\u0002\u0010j\u001a\u00020i¢\u0006\u0004\bk\u0010lJ\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u0005J\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\b\u0015\u0010\u0005J\u000f\u0010\u0016\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0016\u0010\u0005J\u0015\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0014J\r\u0010\u0019\u001a\u00020\u0003¢\u0006\u0004\b\u0019\u0010\u0005J\r\u0010\u001a\u001a\u00020\u0003¢\u0006\u0004\b\u001a\u0010\u0005J\r\u0010\u001b\u001a\u00020\u0003¢\u0006\u0004\b\u001b\u0010\u0005J\u0015\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u0014J\u0015\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u000f¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0003H\u0002¢\u0006\u0004\b%\u0010\u0005J)\u0010(\u001a\u00020\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00062\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010&¢\u0006\u0004\b(\u0010)J\u0015\u0010*\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\b*\u0010\u0014J\u000f\u0010+\u001a\u00020\u0003H\u0002¢\u0006\u0004\b+\u0010\u0005J\u000f\u0010,\u001a\u00020\u0003H\u0002¢\u0006\u0004\b,\u0010\u0005J\r\u0010-\u001a\u00020\u0003¢\u0006\u0004\b-\u0010\u0005J\u000f\u0010.\u001a\u00020\u0003H\u0002¢\u0006\u0004\b.\u0010\u0005J\u000f\u0010/\u001a\u00020\u0003H\u0002¢\u0006\u0004\b/\u0010\u0005R\"\u00100\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u0010\u0011\"\u0004\b3\u0010 R\u0018\u00104\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0018\u0010A\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010D\u001a\u00020C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010G\u001a\u00020F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR$\u0010J\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010P\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u00105\u001a\u0004\bQ\u0010\b\"\u0004\bR\u0010\u0014R\"\u0010T\u001a\u00020S8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001e\u0010Z\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\"\u0010\\\u001a\u0002068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u00108\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\"\u0010a\u001a\u0002068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\ba\u00108\u001a\u0004\bb\u0010^\"\u0004\bc\u0010`R\u0018\u0010d\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u00105¨\u0006o"}, d2 = {"Lcom/baidu/live/feed/search/view/LiveSearchPanel;", "com/baidu/tieba/wa0$a", "Landroid/widget/LinearLayout;", "", "clearEditFocus", "()V", "", "getCurrentQueryHint", "()Ljava/lang/String;", "getText", "Landroid/os/Message;", "msg", "handleMsg", "(Landroid/os/Message;)V", "hideSoftInput", "", "isEditHasFocus", "()Z", "uiMode", "onDarkModeChange", "(Ljava/lang/String;)V", MissionEvent.MESSAGE_DESTROY, "onDetachedFromWindow", "content", "performSearch", "requestEditFocus", "requestInput", "resetView", "showHint", "setCurrentQueryHint", "editable", "setEditable", "(Z)V", "Landroid/view/View$OnClickListener;", "l", "setOnEditClickListener", "(Landroid/view/View$OnClickListener;)V", "setQuery", "", "hintList", "setQueryHintList", "(Ljava/lang/String;Ljava/util/List;)V", "setText", "showHintTextAndSwitcherLoop", "showNextHotWord", "showSoftInput", "startHintSwitcherLoop", "stopHintTextSwitcher", "canSearchHint", "Z", "getCanSearchHint", "setCanSearchHint", "curShowHint", "Ljava/lang/String;", "Landroid/widget/ImageView;", "deleteIcon", "Landroid/widget/ImageView;", "Landroid/widget/EditText;", "editText", "Landroid/widget/EditText;", "getEditText", "()Landroid/widget/EditText;", "setEditText", "(Landroid/widget/EditText;)V", "Landroid/text/TextWatcher;", "editTextChangedListener", "Landroid/text/TextWatcher;", "Lcom/baidu/live/feed/search/utils/WeakHandler;", "handler", "Lcom/baidu/live/feed/search/utils/WeakHandler;", "Landroid/widget/TextSwitcher;", "hintTextSwitcher", "Landroid/widget/TextSwitcher;", "Lcom/baidu/live/feed/search/view/LiveSearchPanel$OnQueryTextListener;", "queryListener", "Lcom/baidu/live/feed/search/view/LiveSearchPanel$OnQueryTextListener;", "getQueryListener", "()Lcom/baidu/live/feed/search/view/LiveSearchPanel$OnQueryTextListener;", "setQueryListener", "(Lcom/baidu/live/feed/search/view/LiveSearchPanel$OnQueryTextListener;)V", "scene", "getScene", "setScene", "Landroid/widget/TextView;", "searchDoneBtn", "Landroid/widget/TextView;", "getSearchDoneBtn", "()Landroid/widget/TextView;", "setSearchDoneBtn", "(Landroid/widget/TextView;)V", "searchHintList", "Ljava/util/List;", "searchTag", "getSearchTag", "()Landroid/widget/ImageView;", "setSearchTag", "(Landroid/widget/ImageView;)V", "splitLineView", "getSplitLineView", "setSplitLineView", "userQuery", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "OnQueryTextListener", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class LiveSearchPanel extends LinearLayout implements wa0.a {
    public ImageView a;
    public EditText b;
    public TextSwitcher c;
    public ImageView d;
    public ImageView e;
    public TextView f;
    public List<String> g;
    public String h;
    public wa0 i;
    public String j;
    public g k;
    public TextWatcher l;
    public boolean m;
    public String n;

    /* loaded from: classes3.dex */
    public interface g {
        void onCancelClick();

        void onQueryTextChange(String str);

        void onQueryTextSubmit(String str);
    }

    @JvmOverloads
    public LiveSearchPanel(Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public LiveSearchPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* loaded from: classes3.dex */
    public static final class a implements TextWatcher {
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z;
            if (editable != null && editable.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                LiveSearchPanel.this.d.setVisibility(8);
                LiveSearchPanel.this.c.setVisibility(0);
                LiveSearchPanel.this.p();
            } else {
                LiveSearchPanel.this.d.setVisibility(0);
                LiveSearchPanel.this.c.setVisibility(8);
                LiveSearchPanel.this.t();
            }
            g queryListener = LiveSearchPanel.this.getQueryListener();
            if (queryListener != null) {
                queryListener.onQueryTextChange(String.valueOf(editable));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements View.OnFocusChangeListener {
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view2, boolean z) {
            boolean z2;
            if (z) {
                Editable text = LiveSearchPanel.this.getEditText().getText();
                if (text != null && text.length() != 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    LiveSearchPanel.this.d.setVisibility(0);
                    return;
                }
            }
            LiveSearchPanel.this.d.setVisibility(8);
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements TextView.OnEditorActionListener {
        public c() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 3) {
                return false;
            }
            LiveSearchPanel.this.o();
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            LiveSearchPanel.this.o();
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements ViewSwitcher.ViewFactory {
        public final /* synthetic */ Context b;

        public e(Context context) {
            this.b = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.ViewSwitcher.ViewFactory
        /* renamed from: a */
        public final TextView makeView() {
            TextView textView = new TextView(this.b);
            textView.setTextSize(0, ca0.c(textView.getResources(), 15.0f));
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setTextColor(tc0.f().a(this.b, LiveSearchPanel.this.getScene(), "color_858585"));
            return textView;
        }
    }

    /* loaded from: classes3.dex */
    public static final class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            LiveSearchPanel.this.getEditText().setText("");
            g queryListener = LiveSearchPanel.this.getQueryListener();
            if (queryListener != null) {
                queryListener.onCancelClick();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            LiveSearchPanel.this.getEditText().setFocusable(true);
            LiveSearchPanel.this.getEditText().setFocusableInTouchMode(true);
            LiveSearchPanel.this.getEditText().requestFocus();
            LiveSearchPanel.this.getEditText().requestFocusFromTouch();
            LiveSearchPanel.this.t();
            LiveSearchPanel.this.r();
        }
    }

    @JvmOverloads
    public LiveSearchPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = new wa0(this);
        this.n = LiveFeedPageSdk.HOST_LIVE_TAB;
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d05c2, (ViewGroup) this, true);
        setBackgroundResource(R.drawable.obfuscated_res_0x7f080ef2);
        setGravity(16);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f091559);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(R.id.live_search_panel_search_tag)");
        this.a = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.obfuscated_res_0x7f091558);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "findViewById(R.id.live_s…panel_hint_text_switcher)");
        this.c = (TextSwitcher) findViewById2;
        View findViewById3 = findViewById(R.id.obfuscated_res_0x7f091557);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "findViewById(R.id.live_search_panel_edit_text)");
        this.b = (EditText) findViewById3;
        View findViewById4 = findViewById(R.id.obfuscated_res_0x7f091555);
        Intrinsics.checkExpressionValueIsNotNull(findViewById4, "findViewById(R.id.live_search_panel_delete)");
        this.d = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.obfuscated_res_0x7f09155a);
        Intrinsics.checkExpressionValueIsNotNull(findViewById5, "findViewById(R.id.live_search_panel_split)");
        this.e = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.obfuscated_res_0x7f091556);
        Intrinsics.checkExpressionValueIsNotNull(findViewById6, "findViewById(R.id.live_search_panel_done_btn)");
        this.f = (TextView) findViewById6;
        this.b.setFilters(new InputFilter[]{va0.a()});
        a aVar = new a();
        this.l = aVar;
        this.b.addTextChangedListener(aVar);
        this.b.setOnFocusChangeListener(new b());
        this.b.setOnEditorActionListener(new c());
        this.f.setOnClickListener(new d());
        this.c.setInAnimation(context, R.anim.obfuscated_res_0x7f0100b0);
        this.c.setOutAnimation(context, R.anim.obfuscated_res_0x7f0100b1);
        this.c.setFactory(new e(context));
        this.d.setOnClickListener(new f());
        this.d.setVisibility(8);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public /* synthetic */ LiveSearchPanel(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static /* synthetic */ void setQueryHintList$default(LiveSearchPanel liveSearchPanel, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        liveSearchPanel.setQueryHintList(str, list);
    }

    @Override // com.baidu.tieba.wa0.a
    public void a(Message message) {
        if (message != null && message.what == 1) {
            q();
            s();
        }
    }

    public final void k(String str) {
        this.b.setText(str);
        o();
    }

    public final void setCanSearchHint(boolean z) {
        this.m = z;
    }

    public final void setCurrentQueryHint(String str) {
        this.h = str;
        this.c.setCurrentText(str);
    }

    public final void setEditText(EditText editText) {
        this.b = editText;
    }

    public final void setEditable(boolean z) {
        if (z) {
            this.b.setFocusable(true);
            this.b.setFocusableInTouchMode(true);
            this.b.requestFocus();
            this.b.requestFocusFromTouch();
            r();
            return;
        }
        this.b.setFocusable(false);
        this.b.setFocusableInTouchMode(false);
    }

    public final void setOnEditClickListener(View.OnClickListener onClickListener) {
        this.b.setOnClickListener(onClickListener);
    }

    public final void setQueryListener(g gVar) {
        this.k = gVar;
    }

    public final void setScene(String str) {
        this.n = str;
    }

    public final void setSearchDoneBtn(TextView textView) {
        this.f = textView;
    }

    public final void setSearchTag(ImageView imageView) {
        this.a = imageView;
    }

    public final void setSplitLineView(ImageView imageView) {
        this.e = imageView;
    }

    public final void setText(String str) {
        this.b.setText(str);
        if (this.b.hasFocus() && this.b.getText() != null) {
            EditText editText = this.b;
            editText.setSelection(editText.getText().length());
        }
    }

    public final void g() {
        Object obj;
        Context context = getContext();
        InputMethodManager inputMethodManager = null;
        if (context != null) {
            obj = context.getSystemService("input_method");
        } else {
            obj = null;
        }
        if (obj instanceof InputMethodManager) {
            inputMethodManager = obj;
        }
        InputMethodManager inputMethodManager2 = inputMethodManager;
        if (inputMethodManager2 != null) {
            inputMethodManager2.hideSoftInputFromWindow(this.b.getWindowToken(), 0);
        }
    }

    public final boolean getCanSearchHint() {
        return this.m;
    }

    public final String getCurrentQueryHint() {
        String str = this.h;
        if (str == null) {
            return "";
        }
        return str;
    }

    public final EditText getEditText() {
        return this.b;
    }

    public final g getQueryListener() {
        return this.k;
    }

    public final String getScene() {
        return this.n;
    }

    public final TextView getSearchDoneBtn() {
        return this.f;
    }

    public final ImageView getSearchTag() {
        return this.a;
    }

    public final ImageView getSplitLineView() {
        return this.e;
    }

    public final String getText() {
        return this.b.getText().toString();
    }

    public final boolean h() {
        return this.b.hasFocus();
    }

    public final void j() {
        g();
        this.i.removeCallbacksAndMessages(null);
        this.b.setOnClickListener(null);
        this.b.setOnEditorActionListener(null);
        this.b.removeTextChangedListener(this.l);
    }

    public final void l() {
        this.b.requestFocus();
    }

    public final void m() {
        this.b.post(new h());
    }

    public final void n() {
        try {
            this.b.setText("");
        } catch (Exception unused) {
        }
        t();
        g();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i.removeCallbacksAndMessages(null);
    }

    public final void p() {
        this.c.setCurrentText(this.h);
        s();
    }

    public final void r() {
        Object obj;
        Context context = getContext();
        InputMethodManager inputMethodManager = null;
        if (context != null) {
            obj = context.getSystemService("input_method");
        } else {
            obj = null;
        }
        if (obj instanceof InputMethodManager) {
            inputMethodManager = obj;
        }
        InputMethodManager inputMethodManager2 = inputMethodManager;
        if (inputMethodManager2 != null) {
            inputMethodManager2.toggleSoftInput(2, 1);
        }
    }

    public final void s() {
        boolean z;
        this.i.removeMessages(1);
        List<String> list = this.g;
        if (list != null && !list.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            this.i.sendEmptyMessageDelayed(1, 5000L);
        }
    }

    public final void t() {
        this.i.removeMessages(1);
    }

    public final void i(String str) {
        if (Intrinsics.areEqual(str, "day")) {
            setBackgroundResource(R.drawable.obfuscated_res_0x7f080ef2);
            this.d.setImageResource(R.drawable.obfuscated_res_0x7f080ef4);
        } else if (Intrinsics.areEqual(str, "night")) {
            setBackgroundResource(R.drawable.obfuscated_res_0x7f080ef3);
            this.d.setImageResource(R.drawable.obfuscated_res_0x7f080ef5);
        }
        this.b.setHintTextColor(tc0.f().a(getContext(), this.n, "color_858585"));
        this.b.setTextColor(tc0.f().a(getContext(), this.n, "color_1F1F1F"));
        this.f.setTextColor(tc0.f().a(getContext(), this.n, "color_4E6EF2"));
        this.e.setBackgroundColor(tc0.f().a(getContext(), this.n, "color_E0E0E0"));
    }

    public final void o() {
        boolean z;
        Editable text = this.b.getText();
        boolean z2 = false;
        if (text != null && text.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z && this.m) {
            this.b.setText(this.h);
        }
        Editable text2 = this.b.getText();
        if (!((text2 == null || text2.length() == 0) ? true : true)) {
            this.j = text2.toString();
            EditText editText = this.b;
            editText.setSelection(editText.length());
            g gVar = this.k;
            if (gVar != null) {
                gVar.onQueryTextSubmit(this.j);
            }
            this.b.clearFocus();
            requestFocus();
            g();
        }
    }

    public final void q() {
        boolean z;
        boolean z2;
        String str;
        List<String> list = this.g;
        if (list != null && !list.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return;
        }
        String str2 = this.h;
        if (str2 != null && str2.length() != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            List<String> list2 = this.g;
            if (list2 == null) {
                Intrinsics.throwNpe();
            }
            str = list2.get(0);
        } else {
            List<String> list3 = this.g;
            if (list3 == null) {
                Intrinsics.throwNpe();
            }
            String str3 = this.h;
            if (str3 == null) {
                Intrinsics.throwNpe();
            }
            int indexOf = list3.indexOf(str3);
            List<String> list4 = this.g;
            if (list4 == null) {
                Intrinsics.throwNpe();
            }
            if (indexOf == list4.size() - 1) {
                List<String> list5 = this.g;
                if (list5 == null) {
                    Intrinsics.throwNpe();
                }
                str = list5.get(0);
            } else {
                List<String> list6 = this.g;
                if (list6 == null) {
                    Intrinsics.throwNpe();
                }
                str = list6.get(indexOf + 1);
            }
        }
        this.h = str;
        this.c.setText(str);
    }

    public final void setQueryHintList(String str, List<String> list) {
        boolean z;
        this.h = str;
        this.g = list;
        boolean z2 = false;
        if (list != null && !list.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.c.setCurrentText("");
            return;
        }
        String str2 = this.h;
        if ((str2 == null || str2.length() == 0) ? true : true) {
            this.h = (String) CollectionsKt___CollectionsKt.random(list, Random.Default);
        }
        this.c.setCurrentText(this.h);
        if (list.size() > 1) {
            s();
        }
    }
}
