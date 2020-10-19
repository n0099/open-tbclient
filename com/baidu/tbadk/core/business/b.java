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
    private TbImageView ejF;
    private TextView ejG;
    private TextView ejH;
    private Button ejI;
    private RelativeLayout ejJ;
    private CustomMessageListener ejK;
    private com.baidu.tbadk.BdToken.completeTask.a mData;
    private int mScreenHeight;
    private int mScreenWidth;

    public b(Context context) {
        super(context);
        this.ejK = new CustomMessageListener(2921420) { // from class: com.baidu.tbadk.core.business.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.dismiss();
            }
        };
        init(context);
        MessageManager.getInstance().registerListener(this.ejK);
    }

    public void init(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.popupwindow_business, (ViewGroup) null);
        this.ejF = (TbImageView) inflate.findViewById(R.id.lower_hair_img);
        this.ejF.setRadius(l.getDimens(context, R.dimen.tbds32));
        this.ejF.setConrers(3);
        this.ejG = (TextView) inflate.findViewById(R.id.lower_hair_text_1);
        this.ejH = (TextView) inflate.findViewById(R.id.lower_hair_text_2);
        this.ejI = (Button) inflate.findViewById(R.id.btn_close);
        this.ejJ = (RelativeLayout) inflate.findViewById(R.id.lower_hair_content);
        this.ejH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.business.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.mData != null) {
                    if (b.this.mData.efc != com.baidu.tbadk.BdToken.completeTask.a.efa) {
                        if (b.this.mData.efc == com.baidu.tbadk.BdToken.completeTask.a.efb && !at.isEmpty(b.this.mData.url)) {
                            b.this.zc(b.this.mData.url);
                        }
                    } else if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), b.this.mData.schema) && !at.isEmpty(b.this.mData.url)) {
                        b.this.zc(b.this.mData.url);
                    }
                    b.this.dismiss();
                }
            }
        });
        this.ejI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.business.b.2
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
                MessageManager.getInstance().unRegisterListener(b.this.ejK);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zc(String str) {
        TbPageContext<?> o;
        if (!at.isEmpty(str) && (o = o(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            be.bmY().b(o, new String[]{str});
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
                this.ejG.setText(context.getResources().getString(R.string.task_already_finish));
            } else {
                this.ejG.setText(aVar.message);
            }
            if (at.isEmpty(aVar.message_color)) {
                this.ejG.setTextColor(context.getResources().getColor(R.color.cp_cont_j));
            } else {
                this.ejG.setTextColor(com.baidu.tieba.lego.card.d.b.fv(aVar.message_color));
            }
            if (at.isEmpty(aVar.btnText)) {
                this.ejH.setText(context.getResources().getString(R.string.back));
            } else {
                this.ejH.setText(aVar.btnText);
            }
            if (at.isEmpty(aVar.btn_text_color)) {
                this.ejH.setTextColor(context.getResources().getColor(R.color.cp_cont_a));
            } else {
                this.ejH.setTextColor(com.baidu.tieba.lego.card.d.b.fv(aVar.btn_text_color));
            }
            if (!at.isEmpty(aVar.btn_color)) {
                this.ejH.setBackgroundDrawable(ap.aN(l.getDimens(context, R.dimen.tbds120), com.baidu.tieba.lego.card.d.b.fv(aVar.btn_color)));
            }
            if (!at.isEmpty(aVar.imgUrl)) {
                this.ejF.startLoad(aVar.imgUrl, 10, false);
            } else {
                this.ejF.startLoad(String.valueOf(R.drawable.banner_size), 24, false);
            }
        }
    }

    public void show() {
        if (bfC() && this.ejJ != null && this.ejJ.getLayoutParams() != null) {
            this.ejJ.getLayoutParams().width = (this.mScreenWidth * 2) / 3;
        }
        showAtLocation(getContentView(), 17, 0, 0);
    }

    private boolean bfC() {
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
