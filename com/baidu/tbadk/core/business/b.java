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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b extends PopupWindow {
    private TbImageView dFV;
    private TextView dFW;
    private TextView dFX;
    private Button dFY;
    private RelativeLayout dFZ;
    private CustomMessageListener dGa;
    private com.baidu.tbadk.BdToken.completeTask.a mData;
    private int mScreenHeight;
    private int mScreenWidth;

    public b(Context context) {
        super(context);
        this.dGa = new CustomMessageListener(2921420) { // from class: com.baidu.tbadk.core.business.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.dismiss();
            }
        };
        init(context);
        MessageManager.getInstance().registerListener(this.dGa);
    }

    public void init(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.popupwindow_business, (ViewGroup) null);
        this.dFV = (TbImageView) inflate.findViewById(R.id.lower_hair_img);
        this.dFV.setRadius(l.getDimens(context, R.dimen.tbds32));
        this.dFV.setConrers(3);
        this.dFW = (TextView) inflate.findViewById(R.id.lower_hair_text_1);
        this.dFX = (TextView) inflate.findViewById(R.id.lower_hair_text_2);
        this.dFY = (Button) inflate.findViewById(R.id.btn_close);
        this.dFZ = (RelativeLayout) inflate.findViewById(R.id.lower_hair_content);
        this.dFX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.business.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.mData != null) {
                    if (b.this.mData.dBK != com.baidu.tbadk.BdToken.completeTask.a.dBI) {
                        if (b.this.mData.dBK == com.baidu.tbadk.BdToken.completeTask.a.dBJ && !ar.isEmpty(b.this.mData.url)) {
                            b.this.uH(b.this.mData.url);
                        }
                    } else if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), b.this.mData.schema) && !ar.isEmpty(b.this.mData.url)) {
                        b.this.uH(b.this.mData.url);
                    }
                    b.this.dismiss();
                }
            }
        });
        this.dFY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.business.b.2
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
                MessageManager.getInstance().unRegisterListener(b.this.dGa);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uH(String str) {
        TbPageContext<?> n;
        if (!ar.isEmpty(str) && (n = n(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            bc.aWU().b(n, new String[]{str});
        }
    }

    private TbPageContext n(Activity activity) {
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
            if (ar.isEmpty(aVar.message)) {
                this.dFW.setText(context.getResources().getString(R.string.task_already_finish));
            } else {
                this.dFW.setText(aVar.message);
            }
            if (ar.isEmpty(aVar.message_color)) {
                this.dFW.setTextColor(context.getResources().getColor(R.color.cp_cont_j));
            } else {
                this.dFW.setTextColor(com.baidu.tieba.lego.card.d.a.dV(aVar.message_color));
            }
            if (ar.isEmpty(aVar.btnText)) {
                this.dFX.setText(context.getResources().getString(R.string.back));
            } else {
                this.dFX.setText(aVar.btnText);
            }
            if (ar.isEmpty(aVar.btn_text_color)) {
                this.dFX.setTextColor(context.getResources().getColor(R.color.cp_cont_a));
            } else {
                this.dFX.setTextColor(com.baidu.tieba.lego.card.d.a.dV(aVar.btn_text_color));
            }
            if (!ar.isEmpty(aVar.btn_color)) {
                this.dFX.setBackgroundDrawable(an.aG(l.getDimens(context, R.dimen.tbds120), com.baidu.tieba.lego.card.d.a.dV(aVar.btn_color)));
            }
            if (!ar.isEmpty(aVar.imgUrl)) {
                this.dFV.startLoad(aVar.imgUrl, 10, false);
            } else {
                this.dFV.startLoad(String.valueOf((int) R.drawable.banner_size), 24, false);
            }
        }
    }

    public void show() {
        if (aPO() && this.dFZ != null && this.dFZ.getLayoutParams() != null) {
            this.dFZ.getLayoutParams().width = (this.mScreenWidth * 2) / 3;
        }
        showAtLocation(getContentView(), 17, 0, 0);
    }

    private boolean aPO() {
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
