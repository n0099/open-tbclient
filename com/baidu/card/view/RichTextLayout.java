package com.baidu.card.view;

import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.card.p;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class RichTextLayout extends LinearLayout implements View.OnClickListener, p<com.baidu.tbadk.core.data.a> {
    private View.OnClickListener afO;
    public TextView agr;
    private boolean ain;
    private final int ald;
    private boolean alf;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;

    public RichTextLayout(Context context) {
        super(context);
        this.ald = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (d.bhw() ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007) * 2 : (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
        this.alf = false;
        this.ain = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.richtext_normal_layout, (ViewGroup) this, true);
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.agr = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.bjd() != null) {
            bx bjd = aVar.bjd();
            OriginalThreadInfo originalThreadInfo = bjd.eEF;
            if (originalThreadInfo != null && this.alf) {
                this.mTitle.setVisibility(8);
                c.bj(this.agr).oV(R.string.F_X01).oU(R.dimen.T_X07);
                if (originalThreadInfo.ezh) {
                    az.a(this.agr, this.mTitle, new SpannableString(originalThreadInfo.title), bjd, this.ald, this.alf, this.ain);
                    ap.setViewTextColor(this.agr, R.color.CAM_X0108);
                } else {
                    az.a(this.agr, this.mTitle, originalThreadInfo.eAh, bjd, this.ald, this.alf, this.ain);
                }
            } else {
                az.a(this.mTitle, bjd, this.ain);
                az.a(this.agr, this.mTitle, bjd.bld(), bjd, this.ald, this.alf, this.ain);
            }
            if (!this.alf) {
                this.agr.setClickable(false);
                this.mTitle.setClickable(false);
            } else if (originalThreadInfo != null && originalThreadInfo.ezh) {
                setOnClickListener(null);
                setClickable(true);
            } else {
                setOnClickListener(this);
                this.agr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.afO != null) {
                            RichTextLayout.this.afO.onClick(view);
                        }
                    }
                });
                this.mTitle.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.RichTextLayout.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (RichTextLayout.this.afO != null) {
                            RichTextLayout.this.afO.onClick(view);
                        }
                    }
                });
                this.agr.setClickable(true);
                this.mTitle.setClickable(true);
            }
        }
    }

    public void setTransmit(boolean z) {
        this.alf = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.afO != null) {
            this.afO.onClick(view);
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.afO = onClickListener;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setNeedFrsTabName(boolean z) {
        this.ain = z;
    }
}
