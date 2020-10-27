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
    private TbImageView ese;
    private TextView esf;
    private TextView esg;
    private Button esh;
    private RelativeLayout esi;
    private CustomMessageListener esj;
    private com.baidu.tbadk.BdToken.completeTask.a mData;
    private int mScreenHeight;
    private int mScreenWidth;

    public b(Context context) {
        super(context);
        this.esj = new CustomMessageListener(2921420) { // from class: com.baidu.tbadk.core.business.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.dismiss();
            }
        };
        init(context);
        MessageManager.getInstance().registerListener(this.esj);
    }

    public void init(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.popupwindow_business, (ViewGroup) null);
        this.ese = (TbImageView) inflate.findViewById(R.id.lower_hair_img);
        this.ese.setRadius(l.getDimens(context, R.dimen.tbds32));
        this.ese.setConrers(3);
        this.esf = (TextView) inflate.findViewById(R.id.lower_hair_text_1);
        this.esg = (TextView) inflate.findViewById(R.id.lower_hair_text_2);
        this.esh = (Button) inflate.findViewById(R.id.btn_close);
        this.esi = (RelativeLayout) inflate.findViewById(R.id.lower_hair_content);
        this.esg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.business.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.mData != null) {
                    if (b.this.mData.enA != com.baidu.tbadk.BdToken.completeTask.a.eny) {
                        if (b.this.mData.enA == com.baidu.tbadk.BdToken.completeTask.a.enz && !at.isEmpty(b.this.mData.url)) {
                            b.this.zv(b.this.mData.url);
                        }
                    } else if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), b.this.mData.schema) && !at.isEmpty(b.this.mData.url)) {
                        b.this.zv(b.this.mData.url);
                    }
                    b.this.dismiss();
                }
            }
        });
        this.esh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.business.b.2
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
                MessageManager.getInstance().unRegisterListener(b.this.esj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zv(String str) {
        TbPageContext<?> o;
        if (!at.isEmpty(str) && (o = o(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            be.boR().b(o, new String[]{str});
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
                this.esf.setText(context.getResources().getString(R.string.task_already_finish));
            } else {
                this.esf.setText(aVar.message);
            }
            if (at.isEmpty(aVar.message_color)) {
                this.esf.setTextColor(context.getResources().getColor(R.color.cp_cont_j));
            } else {
                this.esf.setTextColor(com.baidu.tieba.lego.card.d.b.fv(aVar.message_color));
            }
            if (at.isEmpty(aVar.btnText)) {
                this.esg.setText(context.getResources().getString(R.string.back));
            } else {
                this.esg.setText(aVar.btnText);
            }
            if (at.isEmpty(aVar.btn_text_color)) {
                this.esg.setTextColor(context.getResources().getColor(R.color.cp_cont_a));
            } else {
                this.esg.setTextColor(com.baidu.tieba.lego.card.d.b.fv(aVar.btn_text_color));
            }
            if (!at.isEmpty(aVar.btn_color)) {
                this.esg.setBackgroundDrawable(ap.aO(l.getDimens(context, R.dimen.tbds120), com.baidu.tieba.lego.card.d.b.fv(aVar.btn_color)));
            }
            if (!at.isEmpty(aVar.imgUrl)) {
                this.ese.startLoad(aVar.imgUrl, 10, false);
            } else {
                this.ese.startLoad(String.valueOf(R.drawable.banner_size), 24, false);
            }
        }
    }

    public void show() {
        if (bhv() && this.esi != null && this.esi.getLayoutParams() != null) {
            this.esi.getLayoutParams().width = (this.mScreenWidth * 2) / 3;
        }
        showAtLocation(getContentView(), 17, 0, 0);
    }

    private boolean bhv() {
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
