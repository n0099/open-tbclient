package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class PublishProgressView extends RelativeLayout implements View.OnClickListener {
    private PublishProgressBar fiE;
    private TextView fiF;
    private TextView fiG;
    private bi fiH;

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
        this.fiE = (PublishProgressBar) inflate.findViewById(R.id.progress_bar);
        this.fiF = (TextView) inflate.findViewById(R.id.progress_text);
        this.fiG = (TextView) inflate.findViewById(R.id.progress_close_btn);
        this.fiG.setOnClickListener(this);
        this.fiE.setOnClickListener(this);
        onChangeSkinType();
    }

    public void b(@NonNull bi biVar) {
        if (biVar.equals(this.fiH)) {
            this.fiH.a(biVar);
            updateUI();
            return;
        }
        this.fiH = biVar;
        updateUI();
    }

    public void onChangeSkinType() {
        this.fiE.onChangeSkinType();
        com.baidu.tbadk.core.elementsMaven.c.br(this.fiF).nY(R.color.CAM_X0101).nZ(R.dimen.T_X06).oa(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.fiG).nY(R.color.CAM_X0101).nZ(R.dimen.T_X09).oa(R.string.F_X01);
    }

    private void setProgress(int i) {
        this.fiF.setText(String.format(getResources().getString(R.string.publish_progress_prefix), Integer.valueOf(this.fiE.pE(i))));
    }

    private void updateUI() {
        if (this.fiH != null) {
            if (this.fiH.isRunning()) {
                setProgress(this.fiH.getProgress());
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
            if (this.fiH != null) {
                this.fiH.bmS();
                updateUI();
            }
            com.baidu.tieba.tbadkCore.writeModel.d.dPg();
        }
    }
}
