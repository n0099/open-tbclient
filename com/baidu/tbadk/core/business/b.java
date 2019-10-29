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
    private TbImageView bWr;
    private TextView bWs;
    private TextView bWt;
    private Button bWu;
    private RelativeLayout bWv;
    private CustomMessageListener bWw;
    private com.baidu.tbadk.BdToken.completeTask.a mData;
    private int mScreenHeight;
    private int mScreenWidth;

    public b(Context context) {
        super(context);
        this.bWw = new CustomMessageListener(2921419) { // from class: com.baidu.tbadk.core.business.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.dismiss();
            }
        };
        init(context);
        MessageManager.getInstance().registerListener(this.bWw);
    }

    public void init(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.popupwindow_business, (ViewGroup) null);
        this.bWr = (TbImageView) inflate.findViewById(R.id.lower_hair_img);
        this.bWr.setRadius(l.getDimens(context, R.dimen.tbds32));
        this.bWr.setConrers(3);
        this.bWs = (TextView) inflate.findViewById(R.id.lower_hair_text_1);
        this.bWt = (TextView) inflate.findViewById(R.id.lower_hair_text_2);
        this.bWu = (Button) inflate.findViewById(R.id.btn_close);
        this.bWv = (RelativeLayout) inflate.findViewById(R.id.lower_hair_content);
        this.bWt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.business.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.mData != null) {
                    if (b.this.mData.bTs != com.baidu.tbadk.BdToken.completeTask.a.bTq) {
                        if (b.this.mData.bTs == com.baidu.tbadk.BdToken.completeTask.a.bTr && !aq.isEmpty(b.this.mData.url)) {
                            b.this.lY(b.this.mData.url);
                        }
                    } else if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), b.this.mData.schema) && !aq.isEmpty(b.this.mData.url)) {
                        b.this.lY(b.this.mData.url);
                    }
                    b.this.dismiss();
                }
            }
        });
        this.bWu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.business.b.2
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
                MessageManager.getInstance().unRegisterListener(b.this.bWw);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lY(String str) {
        TbPageContext<?> X;
        if (!aq.isEmpty(str) && (X = X(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            ba.amQ().b(X, new String[]{str});
        }
    }

    private TbPageContext X(Activity activity) {
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
                this.bWs.setText(context.getResources().getString(R.string.task_already_finish));
            } else {
                this.bWs.setText(aVar.message);
            }
            if (aq.isEmpty(aVar.message_color)) {
                this.bWs.setTextColor(context.getResources().getColor(R.color.cp_cont_j));
            } else {
                this.bWs.setTextColor(com.baidu.tieba.lego.card.d.a.bR(aVar.message_color));
            }
            if (aq.isEmpty(aVar.btnText)) {
                this.bWt.setText(context.getResources().getString(R.string.back));
            } else {
                this.bWt.setText(aVar.btnText);
            }
            if (aq.isEmpty(aVar.btn_text_color)) {
                this.bWt.setTextColor(context.getResources().getColor(R.color.cp_cont_a));
            } else {
                this.bWt.setTextColor(com.baidu.tieba.lego.card.d.a.bR(aVar.btn_text_color));
            }
            if (!aq.isEmpty(aVar.btn_color)) {
                this.bWt.setBackgroundDrawable(am.ab(l.getDimens(context, R.dimen.tbds120), com.baidu.tieba.lego.card.d.a.bR(aVar.btn_color)));
            }
            if (!aq.isEmpty(aVar.imgUrl)) {
                this.bWr.startLoad(aVar.imgUrl, 10, false);
            } else {
                this.bWr.startLoad(String.valueOf((int) R.drawable.banner_size), 24, false);
            }
        }
    }

    public void show() {
        if (agE() && this.bWv != null && this.bWv.getLayoutParams() != null) {
            this.bWv.getLayoutParams().width = (this.mScreenWidth * 2) / 3;
        }
        showAtLocation(getContentView(), 17, 0, 0);
    }

    private boolean agE() {
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
