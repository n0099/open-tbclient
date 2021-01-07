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
    private PublishProgressBar fkW;
    private TextView fkX;
    private TextView fkY;
    private bg fkZ;

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
        this.fkW = (PublishProgressBar) inflate.findViewById(R.id.progress_bar);
        this.fkX = (TextView) inflate.findViewById(R.id.progress_text);
        this.fkY = (TextView) inflate.findViewById(R.id.progress_close_btn);
        this.fkY.setOnClickListener(this);
        this.fkW.setOnClickListener(this);
        onChangeSkinType();
    }

    public void b(@NonNull bg bgVar) {
        if (bgVar.equals(this.fkZ)) {
            this.fkZ.a(bgVar);
            updateUI();
            return;
        }
        this.fkZ = bgVar;
        updateUI();
    }

    public void onChangeSkinType() {
        this.fkW.onChangeSkinType();
        com.baidu.tbadk.core.elementsMaven.c.bv(this.fkX).pC(R.color.CAM_X0101).pD(R.dimen.T_X06).pE(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.fkY).pC(R.color.CAM_X0101).pD(R.dimen.T_X09).pE(R.string.F_X01);
    }

    private void setProgress(int i) {
        this.fkX.setText(String.format(getResources().getString(R.string.publish_progress_prefix), Integer.valueOf(this.fkW.rf(i))));
    }

    private void updateUI() {
        if (this.fkZ != null) {
            if (this.fkZ.isRunning()) {
                setProgress(this.fkZ.getProgress());
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
            if (this.fkZ != null) {
                this.fkZ.bqt();
                updateUI();
            }
            com.baidu.tieba.tbadkCore.writeModel.d.dQN();
        }
    }
}
