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
public class b extends PopupWindow {
    private TbImageView ewn;
    private TextView ewo;
    private TextView ewp;
    private Button ewq;
    private RelativeLayout ewr;
    private CustomMessageListener ews;
    private com.baidu.tbadk.BdToken.completeTask.a mData;
    private int mScreenHeight;
    private int mScreenWidth;

    public b(Context context) {
        super(context);
        this.ews = new CustomMessageListener(2921420) { // from class: com.baidu.tbadk.core.business.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.dismiss();
            }
        };
        init(context);
        MessageManager.getInstance().registerListener(this.ews);
    }

    public void init(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.popupwindow_business, (ViewGroup) null);
        this.ewn = (TbImageView) inflate.findViewById(R.id.lower_hair_img);
        this.ewn.setRadius(l.getDimens(context, R.dimen.tbds32));
        this.ewn.setConrers(3);
        this.ewo = (TextView) inflate.findViewById(R.id.lower_hair_text_1);
        this.ewp = (TextView) inflate.findViewById(R.id.lower_hair_text_2);
        this.ewq = (Button) inflate.findViewById(R.id.btn_close);
        this.ewr = (RelativeLayout) inflate.findViewById(R.id.lower_hair_content);
        this.ewp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.business.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.mData != null) {
                    if (b.this.mData.erO != com.baidu.tbadk.BdToken.completeTask.a.erM) {
                        if (b.this.mData.erO == com.baidu.tbadk.BdToken.completeTask.a.erN && !au.isEmpty(b.this.mData.url)) {
                            b.this.dealJump(b.this.mData.url);
                        }
                    } else if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), b.this.mData.schema) && !au.isEmpty(b.this.mData.url)) {
                        b.this.dealJump(b.this.mData.url);
                    }
                    b.this.dismiss();
                }
            }
        });
        this.ewq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.business.b.2
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
                MessageManager.getInstance().unRegisterListener(b.this.ews);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealJump(String str) {
        TbPageContext<?> currentActivityPageContext;
        if (!au.isEmpty(str) && (currentActivityPageContext = getCurrentActivityPageContext(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            bf.bqF().b(currentActivityPageContext, new String[]{str});
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
                this.ewo.setText(context.getResources().getString(R.string.task_already_finish));
            } else {
                this.ewo.setText(aVar.message);
            }
            if (au.isEmpty(aVar.message_color)) {
                this.ewo.setTextColor(context.getResources().getColor(R.color.CAM_X0107));
            } else {
                this.ewo.setTextColor(com.baidu.tieba.lego.card.d.b.sa(aVar.message_color));
            }
            if (au.isEmpty(aVar.btnText)) {
                this.ewp.setText(context.getResources().getString(R.string.back));
            } else {
                this.ewp.setText(aVar.btnText);
            }
            if (au.isEmpty(aVar.btn_text_color)) {
                this.ewp.setTextColor(context.getResources().getColor(R.color.CAM_X0101));
            } else {
                this.ewp.setTextColor(com.baidu.tieba.lego.card.d.b.sa(aVar.btn_text_color));
            }
            if (!au.isEmpty(aVar.btn_color)) {
                this.ewp.setBackgroundDrawable(ap.aP(l.getDimens(context, R.dimen.tbds120), com.baidu.tieba.lego.card.d.b.sa(aVar.btn_color)));
            }
            if (!au.isEmpty(aVar.imgUrl)) {
                this.ewn.startLoad(aVar.imgUrl, 10, false);
            } else {
                this.ewn.startLoad(String.valueOf(R.drawable.banner_size), 24, false);
            }
        }
    }

    public void show() {
        if (biZ() && this.ewr != null && this.ewr.getLayoutParams() != null) {
            this.ewr.getLayoutParams().width = (this.mScreenWidth * 2) / 3;
        }
        showAtLocation(getContentView(), 17, 0, 0);
    }

    private boolean biZ() {
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
