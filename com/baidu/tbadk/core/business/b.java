package com.baidu.tbadk.core.business;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b extends PopupWindow {
    private TbImageView dXD;
    private TextView dXE;
    private TextView dXF;
    private Button dXG;
    private RelativeLayout dXH;
    private CustomMessageListener dXI;
    private com.baidu.tbadk.BdToken.completeTask.a mData;
    private int mScreenHeight;
    private int mScreenWidth;

    public b(Context context) {
        super(context);
        this.dXI = new CustomMessageListener(2921420) { // from class: com.baidu.tbadk.core.business.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.dismiss();
            }
        };
        init(context);
        MessageManager.getInstance().registerListener(this.dXI);
    }

    public void init(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.popupwindow_business, (ViewGroup) null);
        this.dXD = (TbImageView) inflate.findViewById(R.id.lower_hair_img);
        this.dXD.setRadius(l.getDimens(context, R.dimen.tbds32));
        this.dXD.setConrers(3);
        this.dXE = (TextView) inflate.findViewById(R.id.lower_hair_text_1);
        this.dXF = (TextView) inflate.findViewById(R.id.lower_hair_text_2);
        this.dXG = (Button) inflate.findViewById(R.id.btn_close);
        this.dXH = (RelativeLayout) inflate.findViewById(R.id.lower_hair_content);
        this.dXF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.business.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.mData != null) {
                    if (b.this.mData.dTb != com.baidu.tbadk.BdToken.completeTask.a.dSZ) {
                        if (b.this.mData.dTb == com.baidu.tbadk.BdToken.completeTask.a.dTa && !at.isEmpty(b.this.mData.url)) {
                            b.this.yq(b.this.mData.url);
                        }
                    } else if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), b.this.mData.schema) && !at.isEmpty(b.this.mData.url)) {
                        b.this.yq(b.this.mData.url);
                    }
                    b.this.dismiss();
                }
            }
        });
        this.dXG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.business.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.dismiss();
            }
        });
        setContentView(inflate);
        setWidth(-1);
        setHeight(-1);
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(R.color.black_alpha35)));
        setAnimationStyle(R.style.UpdateStyle);
        setClippingEnabled(false);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tbadk.core.business.b.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                MessageManager.getInstance().unRegisterListener(b.this.dXI);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yq(String str) {
        TbPageContext<?> o;
        if (!at.isEmpty(str) && (o = o(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            be.bkp().b(o, new String[]{str});
        }
    }

    private TbPageContext o(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }

    public void a(Context context, com.baidu.tbadk.BdToken.completeTask.a aVar) {
        if (aVar != null) {
            this.mData = aVar;
            if (at.isEmpty(aVar.message)) {
                this.dXE.setText(context.getResources().getString(R.string.task_already_finish));
            } else {
                this.dXE.setText(aVar.message);
            }
            if (at.isEmpty(aVar.message_color)) {
                this.dXE.setTextColor(context.getResources().getColor(R.color.cp_cont_j));
            } else {
                this.dXE.setTextColor(com.baidu.tieba.lego.card.d.b.fq(aVar.message_color));
            }
            if (at.isEmpty(aVar.btnText)) {
                this.dXF.setText(context.getResources().getString(R.string.back));
            } else {
                this.dXF.setText(aVar.btnText);
            }
            if (at.isEmpty(aVar.btn_text_color)) {
                this.dXF.setTextColor(context.getResources().getColor(R.color.cp_cont_a));
            } else {
                this.dXF.setTextColor(com.baidu.tieba.lego.card.d.b.fq(aVar.btn_text_color));
            }
            if (!at.isEmpty(aVar.btn_color)) {
                this.dXF.setBackgroundDrawable(ap.aO(l.getDimens(context, R.dimen.tbds120), com.baidu.tieba.lego.card.d.b.fq(aVar.btn_color)));
            }
            if (!at.isEmpty(aVar.imgUrl)) {
                this.dXD.startLoad(aVar.imgUrl, 10, false);
            } else {
                this.dXD.startLoad(String.valueOf(R.drawable.banner_size), 24, false);
            }
        }
    }

    public void show() {
        if (bcU() && this.dXH != null && this.dXH.getLayoutParams() != null) {
            this.dXH.getLayoutParams().width = (this.mScreenWidth * 2) / 3;
        }
        showAtLocation(getContentView(), 17, 0, 0);
    }

    private boolean bcU() {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            currentActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.mScreenWidth = displayMetrics.widthPixels;
            this.mScreenHeight = displayMetrics.heightPixels;
        }
        return this.mScreenHeight > 2000 && this.mScreenWidth > 2000;
    }
}
