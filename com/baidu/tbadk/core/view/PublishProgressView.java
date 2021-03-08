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
    private PublishProgressBar fkd;
    private TextView fke;
    private TextView fkf;
    private bi fkg;

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
        this.fkd = (PublishProgressBar) inflate.findViewById(R.id.progress_bar);
        this.fke = (TextView) inflate.findViewById(R.id.progress_text);
        this.fkf = (TextView) inflate.findViewById(R.id.progress_close_btn);
        this.fkf.setOnClickListener(this);
        this.fkd.setOnClickListener(this);
        onChangeSkinType();
    }

    public void b(@NonNull bi biVar) {
        if (biVar.equals(this.fkg)) {
            this.fkg.a(biVar);
            updateUI();
            return;
        }
        this.fkg = biVar;
        updateUI();
    }

    public void onChangeSkinType() {
        this.fkd.onChangeSkinType();
        com.baidu.tbadk.core.elementsMaven.c.br(this.fke).nZ(R.color.CAM_X0101).oa(R.dimen.T_X06).ob(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.fkf).nZ(R.color.CAM_X0101).oa(R.dimen.T_X09).ob(R.string.F_X01);
    }

    private void setProgress(int i) {
        this.fke.setText(String.format(getResources().getString(R.string.publish_progress_prefix), Integer.valueOf(this.fkd.pF(i))));
    }

    private void updateUI() {
        if (this.fkg != null) {
            if (this.fkg.isRunning()) {
                setProgress(this.fkg.getProgress());
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
            if (this.fkg != null) {
                this.fkg.bmU();
                updateUI();
            }
            com.baidu.tieba.tbadkCore.writeModel.d.dPx();
        }
    }
}
