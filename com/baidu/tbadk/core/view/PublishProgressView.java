package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class PublishProgressView extends RelativeLayout implements View.OnClickListener {
    private PublishProgressBar fgl;
    private TextView fgm;
    private TextView fgn;
    private bg fgo;

    public PublishProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    public PublishProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public PublishProgressView(Context context) {
        super(context);
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.publish_progress_view, this);
        this.fgl = (PublishProgressBar) inflate.findViewById(R.id.progress_bar);
        this.fgm = (TextView) inflate.findViewById(R.id.progress_text);
        this.fgn = (TextView) inflate.findViewById(R.id.progress_close_btn);
        this.fgn.setOnClickListener(this);
        this.fgl.setOnClickListener(this);
        onChangeSkinType();
    }

    public void b(@NonNull bg bgVar) {
        if (bgVar.equals(this.fgo)) {
            this.fgo.a(bgVar);
            updateUI();
            return;
        }
        this.fgo = bgVar;
        updateUI();
    }

    public void onChangeSkinType() {
        this.fgl.onChangeSkinType();
        com.baidu.tbadk.core.elementsMaven.c.bv(this.fgm).nV(R.color.CAM_X0101).nW(R.dimen.T_X06).nX(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.fgn).nV(R.color.CAM_X0101).nW(R.dimen.T_X09).nX(R.string.F_X01);
    }

    private void setProgress(int i) {
        this.fgm.setText(String.format(getResources().getString(R.string.publish_progress_prefix), Integer.valueOf(this.fgl.pz(i))));
    }

    private void updateUI() {
        if (this.fgo != null) {
            if (this.fgo.isRunning()) {
                setProgress(this.fgo.getProgress());
                setVisibility(0);
                return;
            }
            setVisibility(8);
            setProgress(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.progress_close_btn) {
            if (this.fgo != null) {
                this.fgo.bmz();
                updateUI();
            }
            com.baidu.tieba.tbadkCore.writeModel.d.dMV();
        }
    }
}
