package com.baidu.tbadk.browser.newshare;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareInfo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private TextView aht;
    private final ThreadAchievementShareInfo eAW;
    private final ThreadAchievementShareInfo.ParamBean eAX;
    private TbRichTextView eBC;
    private com.baidu.tbadk.widget.richText.a eBD;
    private TbImageView eBE;
    private TextView eBF;
    private TextView eBG;
    private TextView eBH;
    private TextView eBI;
    private final Context mContext;
    private final View mRoot;

    public b(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.normal_interaction_achievement, (ViewGroup) null);
        this.eAW = threadAchievementShareInfo;
        this.eAX = threadAchievementShareInfo.getParams();
        initUI();
        initData();
    }

    private void initData() {
        if (this.eAX.getContent() != null && this.eAX.getContent().size() != 0) {
            JSONArray jSONArray = new JSONArray();
            ThreadAchievementShareInfo.ContentBean contentBean = null;
            for (ThreadAchievementShareInfo.ContentBean contentBean2 : this.eAX.getContent()) {
                if (contentBean2.getType() == 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "0");
                        jSONObject.put("text", contentBean2.getText());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    jSONArray.put(jSONObject);
                    contentBean2 = contentBean;
                } else if (contentBean2.getType() != 3) {
                    contentBean2 = contentBean;
                }
                contentBean = contentBean2;
            }
            if (!TextUtils.isEmpty(this.eAX.getThread_title())) {
                this.aht.setText(this.eAX.getThread_title());
                this.aht.setVisibility(0);
                this.eBC.setMaxLines(6);
            } else {
                ((LinearLayout.LayoutParams) this.eBC.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds20);
                this.eBC.setMaxLines(8);
            }
            this.eBC.setTextEllipsize(TextUtils.TruncateAt.END);
            this.eBC.setMinimumHeight(l.getDimens(this.mContext, R.dimen.tbds516));
            if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.eAX.getThread_type().contains(UgcUBCUtils.UGC_TYPE_PIC_BTN)) {
                this.eBE.setVisibility(0);
                this.eBE.setDefaultBgResource(R.color.transparent);
                this.eBE.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.eBE.setPlaceHolder(2);
                this.eBE.startLoad(contentBean.getSrc(), 10, false);
                if (!TextUtils.isEmpty(this.eAX.getThread_title())) {
                    this.eBC.setVisibility(8);
                } else {
                    this.eBC.setMaxLines(2);
                    this.eBC.setTextEllipsize(TextUtils.TruncateAt.END);
                    this.eBC.setLayoutStrategy(this.eBD);
                    this.eBC.setMinimumHeight(l.getDimens(this.mContext, R.dimen.tbds0));
                }
            }
            this.eBC.setText(TbRichTextView.a(this.mContext, jSONArray, false));
            this.eBI.setText(au.ea(this.eAX.getAgree_num()));
            this.eBF.setText(au.ea(this.eAX.getPost_num()));
        }
    }

    private void initUI() {
        this.eBF = (TextView) this.mRoot.findViewById(R.id.comment_num);
        this.eBG = (TextView) this.mRoot.findViewById(R.id.comment_desc);
        this.eBH = (TextView) this.mRoot.findViewById(R.id.praise_desc);
        this.eBI = (TextView) this.mRoot.findViewById(R.id.praise_num);
        this.aht = (TextView) this.mRoot.findViewById(R.id.thread_title);
        this.eBE = (TbImageView) this.mRoot.findViewById(R.id.main_img);
        this.eBC = (TbRichTextView) this.mRoot.findViewById(R.id.rich_text);
        this.eBI.setTextColor(ap.getColor(R.color.CAM_X0310));
        this.eBF.setTextColor(ap.getColor(R.color.CAM_X0310));
        this.eBH.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.eBG.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.aht.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.eBD = new com.baidu.tbadk.widget.richText.a();
        this.eBD.tt(l.getDimens(this.mContext, R.dimen.tbds38));
        this.eBD.setTextSize(l.getDimens(this.mContext, R.dimen.tbds42));
        this.eBD.tx(l.getDimens(this.mContext, R.dimen.tbds23));
        this.eBD.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12), 1.0f);
        this.eBD.bt(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.eBC.setLayoutStrategy(this.eBD);
        this.eBC.setTextColor(ap.getColor(R.color.CAM_X0105));
    }

    public View getView() {
        return this.mRoot;
    }
}
