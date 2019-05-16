package com.baidu.tbadk.core.business;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b extends PopupWindow {
    private TbImageView bDe;
    private TextView bDf;
    private TextView bDg;
    private Button bDh;
    private CustomMessageListener bDi;
    private com.baidu.tbadk.BdToken.completeTask.a mData;

    public b(Context context) {
        super(context);
        this.bDi = new CustomMessageListener(2921419) { // from class: com.baidu.tbadk.core.business.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.dismiss();
            }
        };
        init(context);
        MessageManager.getInstance().registerListener(this.bDi);
    }

    public void init(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.popupwindow_business, (ViewGroup) null);
        this.bDe = (TbImageView) inflate.findViewById(R.id.lower_hair_img);
        this.bDe.setRadius(l.g(context, R.dimen.tbds32));
        this.bDe.setConrers(3);
        this.bDf = (TextView) inflate.findViewById(R.id.lower_hair_text_1);
        this.bDg = (TextView) inflate.findViewById(R.id.lower_hair_text_2);
        this.bDh = (Button) inflate.findViewById(R.id.btn_close);
        this.bDg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.business.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.mData != null) {
                    if (b.this.mData.bzr != com.baidu.tbadk.BdToken.completeTask.a.bzp) {
                        if (b.this.mData.bzr == com.baidu.tbadk.BdToken.completeTask.a.bzq && !ap.isEmpty(b.this.mData.url)) {
                            b.this.lm(b.this.mData.url);
                        }
                    } else if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), b.this.mData.schema) && !ap.isEmpty(b.this.mData.url)) {
                        b.this.lm(b.this.mData.url);
                    }
                    b.this.dismiss();
                }
            }
        });
        this.bDh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.business.b.2
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
                MessageManager.getInstance().unRegisterListener(b.this.bDi);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lm(String str) {
        TbPageContext<?> V;
        if (!ap.isEmpty(str) && (V = V(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            ba.aiz().c(V, new String[]{str});
        }
    }

    private TbPageContext V(Activity activity) {
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
            if (ap.isEmpty(aVar.message)) {
                this.bDf.setText(context.getResources().getString(R.string.task_already_finish));
            } else {
                this.bDf.setText(aVar.message);
            }
            if (ap.isEmpty(aVar.message_color)) {
                this.bDf.setTextColor(context.getResources().getColor(R.color.cp_cont_j));
            } else {
                this.bDf.setTextColor(com.baidu.tieba.lego.card.d.a.parseColor(aVar.message_color));
            }
            if (ap.isEmpty(aVar.btnText)) {
                this.bDg.setText(context.getResources().getString(R.string.back));
            } else {
                this.bDg.setText(aVar.btnText);
            }
            if (ap.isEmpty(aVar.btn_text_color)) {
                this.bDg.setTextColor(context.getResources().getColor(R.color.cp_btn_a));
            } else {
                this.bDg.setTextColor(com.baidu.tieba.lego.card.d.a.parseColor(aVar.btn_text_color));
            }
            if (!ap.isEmpty(aVar.btn_color)) {
                this.bDg.setBackgroundDrawable(al.U(l.g(context, R.dimen.tbds120), com.baidu.tieba.lego.card.d.a.parseColor(aVar.btn_color)));
            }
            if (!ap.isEmpty(aVar.imgUrl)) {
                this.bDe.startLoad(aVar.imgUrl, 10, false);
            } else {
                this.bDe.startLoad(String.valueOf((int) R.drawable.banner_size), 24, false);
            }
        }
    }

    public void show() {
        showAtLocation(getContentView(), 17, 0, 0);
    }
}
