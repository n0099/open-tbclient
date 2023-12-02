package com.baidu.nadcore.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.annotation.Nullable;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.on0;
/* loaded from: classes3.dex */
public class NadExpressBigImgOperateView extends NadExpressNaBaseView {
    @Nullable
    public AdImageView k;

    public NadExpressBigImgOperateView(Context context) {
        this(context, null);
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void h(Context context) {
        this.k = (AdImageView) findViewById(R.id.nad_feed_template_big_image_id);
    }

    public NadExpressBigImgOperateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.baidu.nadcore.widget.view.NadExpressNaBaseView
    public void g(LayoutInflater layoutInflater, on0 on0Var) {
        int i;
        if (on0Var != null && on0Var.a(AdBaseModel.STYLE.BIG_IMAGE) != 0) {
            i = on0Var.a(AdBaseModel.STYLE.BIG_IMAGE);
        } else {
            i = R.layout.nad_feed_big_image;
        }
        layoutInflater.inflate(i, this);
    }

    public NadExpressBigImgOperateView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public NadExpressBigImgOperateView(Context context, AttributeSet attributeSet, int i, on0 on0Var) {
        super(context, attributeSet, i, on0Var);
    }
}
