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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends PopupWindow {
    private RelativeLayout eKA;
    private CustomMessageListener eKB;
    private TbImageView eKw;
    private TextView eKx;
    private TextView eKy;
    private Button eKz;
    private com.baidu.tbadk.BdToken.completeTask.a mData;
    private int mScreenHeight;
    private int mScreenWidth;

    public c(Context context) {
        super(context);
        this.eKB = new CustomMessageListener(2921420) { // from class: com.baidu.tbadk.core.business.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.dismiss();
            }
        };
        init(context);
        MessageManager.getInstance().registerListener(this.eKB);
    }

    public void init(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.popupwindow_business, (ViewGroup) null);
        this.eKw = (TbImageView) inflate.findViewById(R.id.lower_hair_img);
        this.eKw.setRadius(l.getDimens(context, R.dimen.tbds32));
        this.eKw.setConrers(3);
        this.eKx = (TextView) inflate.findViewById(R.id.lower_hair_text_1);
        this.eKy = (TextView) inflate.findViewById(R.id.lower_hair_text_2);
        this.eKz = (Button) inflate.findViewById(R.id.btn_close);
        this.eKA = (RelativeLayout) inflate.findViewById(R.id.lower_hair_content);
        this.eKy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.business.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.mData != null) {
                    if (c.this.mData.eFC != com.baidu.tbadk.BdToken.completeTask.a.eFA) {
                        if (c.this.mData.eFC == com.baidu.tbadk.BdToken.completeTask.a.eFB && !au.isEmpty(c.this.mData.url)) {
                            c.this.dealJump(c.this.mData.url);
                        }
                    } else if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), c.this.mData.schema) && !au.isEmpty(c.this.mData.url)) {
                        c.this.dealJump(c.this.mData.url);
                    }
                    c.this.dismiss();
                }
            }
        });
        this.eKz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.business.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.dismiss();
            }
        });
        setContentView(inflate);
        setWidth(-1);
        setHeight(-1);
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(R.color.black_alpha35)));
        setAnimationStyle(R.style.UpdateStyle);
        setClippingEnabled(false);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tbadk.core.business.c.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                MessageManager.getInstance().unRegisterListener(c.this.eKB);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealJump(String str) {
        TbPageContext<?> currentActivityPageContext;
        if (!au.isEmpty(str) && (currentActivityPageContext = getCurrentActivityPageContext(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            bf.bsV().b(currentActivityPageContext, new String[]{str});
        }
    }

    private TbPageContext getCurrentActivityPageContext(Activity activity) {
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
            if (au.isEmpty(aVar.message)) {
                this.eKx.setText(context.getResources().getString(R.string.task_already_finish));
            } else {
                this.eKx.setText(aVar.message);
            }
            if (au.isEmpty(aVar.message_color)) {
                this.eKx.setTextColor(context.getResources().getColor(R.color.CAM_X0107));
            } else {
                this.eKx.setTextColor(com.baidu.tieba.lego.card.c.b.rM(aVar.message_color));
            }
            if (au.isEmpty(aVar.btnText)) {
                this.eKy.setText(context.getResources().getString(R.string.back));
            } else {
                this.eKy.setText(aVar.btnText);
            }
            if (au.isEmpty(aVar.btn_text_color)) {
                this.eKy.setTextColor(context.getResources().getColor(R.color.CAM_X0101));
            } else {
                this.eKy.setTextColor(com.baidu.tieba.lego.card.c.b.rM(aVar.btn_text_color));
            }
            if (!au.isEmpty(aVar.btn_color)) {
                this.eKy.setBackgroundDrawable(ap.aL(l.getDimens(context, R.dimen.tbds120), com.baidu.tieba.lego.card.c.b.rM(aVar.btn_color)));
            }
            if (!au.isEmpty(aVar.imgUrl)) {
                this.eKw.startLoad(aVar.imgUrl, 10, false);
            } else {
                this.eKw.startLoad(String.valueOf(R.drawable.banner_size), 24, false);
            }
        }
    }

    public void show() {
        if (blj() && this.eKA != null && this.eKA.getLayoutParams() != null) {
            this.eKA.getLayoutParams().width = (this.mScreenWidth * 2) / 3;
        }
        showAtLocation(getContentView(), 17, 0, 0);
    }

    private boolean blj() {
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
