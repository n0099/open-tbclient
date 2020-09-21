package com.baidu.live.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes4.dex */
public class AlaEmoticonView extends FrameLayout {
    private SimpleDraweeView bqU;
    private TbImageView bqV;
    private a bqW;

    /* loaded from: classes4.dex */
    public interface a {
    }

    public AlaEmoticonView(Context context) {
        this(context, null);
    }

    public AlaEmoticonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlaEmoticonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.h.ala_emoticon_view, (ViewGroup) this, true);
        this.bqU = (SimpleDraweeView) inflate.findViewById(a.g.emoticon_iv);
        this.bqV = (TbImageView) inflate.findViewById(a.g.emoticon_result_iv);
    }

    public void stopLoad() {
        if (this.bqU != null && this.bqU.getController() != null && this.bqU.getController().dUa() != null && this.bqU.getController().dUa().isRunning()) {
            this.bqU.getController().dUa().stop();
        }
    }

    public void setEmoticonListener(a aVar) {
        this.bqW = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopLoad();
    }
}
