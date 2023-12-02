package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.u03;
/* loaded from: classes4.dex */
public class FooterLoadingLayout extends LoadingLayout {
    public LoadingAnimView e;
    public TextView f;

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
    }

    public FooterLoadingLayout(Context context) {
        super(context);
        n(context);
    }

    public final void n(Context context) {
        this.e = (LoadingAnimView) findViewById(R.id.obfuscated_res_0x7f091e9f);
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091e9e);
        this.f = textView;
        textView.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060455));
        setState(ILoadingLayout$State.RESET);
    }

    public FooterLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        n(context);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void l(ILoadingLayout$State iLoadingLayout$State, ILoadingLayout$State iLoadingLayout$State2) {
        this.e.setVisibility(8);
        this.e.e();
        this.f.setVisibility(4);
        super.l(iLoadingLayout$State, iLoadingLayout$State2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        View b = u03.a().b(R.layout.obfuscated_res_0x7f0d00cd, viewGroup, false);
        b.setBackgroundColor(context.getResources().getColor(R.color.obfuscated_res_0x7f06045d));
        return b;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void c() {
        this.f.setVisibility(0);
        this.f.setText(R.string.obfuscated_res_0x7f0f01ec);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void g() {
        this.f.setVisibility(0);
        this.f.setText(R.string.obfuscated_res_0x7f0f01e9);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        View findViewById = findViewById(R.id.obfuscated_res_0x7f091e9d);
        if (findViewById != null) {
            return findViewById.getHeight();
        }
        return (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070165);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void h() {
        this.e.setVisibility(0);
        this.e.d();
        this.f.setVisibility(0);
        this.f.setText(R.string.obfuscated_res_0x7f0f01e8);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void j() {
        this.f.setVisibility(0);
        this.f.setText(R.string.obfuscated_res_0x7f0f01ea);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void k() {
        this.f.setText(R.string.obfuscated_res_0x7f0f01e8);
    }
}
