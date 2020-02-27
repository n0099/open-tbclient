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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b extends PopupWindow {
    private TbImageView cMf;
    private TextView cMg;
    private TextView cMh;
    private Button cMi;
    private RelativeLayout cMj;
    private CustomMessageListener cMk;
    private com.baidu.tbadk.BdToken.completeTask.a mData;
    private int mScreenHeight;
    private int mScreenWidth;

    public b(Context context) {
        super(context);
        this.cMk = new CustomMessageListener(2921420) { // from class: com.baidu.tbadk.core.business.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.dismiss();
            }
        };
        init(context);
        MessageManager.getInstance().registerListener(this.cMk);
    }

    public void init(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.popupwindow_business, (ViewGroup) null);
        this.cMf = (TbImageView) inflate.findViewById(R.id.lower_hair_img);
        this.cMf.setRadius(l.getDimens(context, R.dimen.tbds32));
        this.cMf.setConrers(3);
        this.cMg = (TextView) inflate.findViewById(R.id.lower_hair_text_1);
        this.cMh = (TextView) inflate.findViewById(R.id.lower_hair_text_2);
        this.cMi = (Button) inflate.findViewById(R.id.btn_close);
        this.cMj = (RelativeLayout) inflate.findViewById(R.id.lower_hair_content);
        this.cMh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.business.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.mData != null) {
                    if (b.this.mData.cJp != com.baidu.tbadk.BdToken.completeTask.a.cJn) {
                        if (b.this.mData.cJp == com.baidu.tbadk.BdToken.completeTask.a.cJo && !aq.isEmpty(b.this.mData.url)) {
                            b.this.rE(b.this.mData.url);
                        }
                    } else if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), b.this.mData.schema) && !aq.isEmpty(b.this.mData.url)) {
                        b.this.rE(b.this.mData.url);
                    }
                    b.this.dismiss();
                }
            }
        });
        this.cMi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.business.b.2
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
                MessageManager.getInstance().unRegisterListener(b.this.cMk);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rE(String str) {
        TbPageContext<?> r;
        if (!aq.isEmpty(str) && (r = r(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            ba.aGE().b(r, new String[]{str});
        }
    }

    private TbPageContext r(Activity activity) {
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
            if (aq.isEmpty(aVar.message)) {
                this.cMg.setText(context.getResources().getString(R.string.task_already_finish));
            } else {
                this.cMg.setText(aVar.message);
            }
            if (aq.isEmpty(aVar.message_color)) {
                this.cMg.setTextColor(context.getResources().getColor(R.color.cp_cont_j));
            } else {
                this.cMg.setTextColor(com.baidu.tieba.lego.card.d.a.cG(aVar.message_color));
            }
            if (aq.isEmpty(aVar.btnText)) {
                this.cMh.setText(context.getResources().getString(R.string.back));
            } else {
                this.cMh.setText(aVar.btnText);
            }
            if (aq.isEmpty(aVar.btn_text_color)) {
                this.cMh.setTextColor(context.getResources().getColor(R.color.cp_cont_a));
            } else {
                this.cMh.setTextColor(com.baidu.tieba.lego.card.d.a.cG(aVar.btn_text_color));
            }
            if (!aq.isEmpty(aVar.btn_color)) {
                this.cMh.setBackgroundDrawable(am.ay(l.getDimens(context, R.dimen.tbds120), com.baidu.tieba.lego.card.d.a.cG(aVar.btn_color)));
            }
            if (!aq.isEmpty(aVar.imgUrl)) {
                this.cMf.startLoad(aVar.imgUrl, 10, false);
            } else {
                this.cMf.startLoad(String.valueOf((int) R.drawable.banner_size), 24, false);
            }
        }
    }

    public void show() {
        if (aAa() && this.cMj != null && this.cMj.getLayoutParams() != null) {
            this.cMj.getLayoutParams().width = (this.mScreenWidth * 2) / 3;
        }
        showAtLocation(getContentView(), 17, 0, 0);
    }

    private boolean aAa() {
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
