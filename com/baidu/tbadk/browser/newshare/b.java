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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private TextView afW;
    private TbRichTextView dVQ;
    private com.baidu.tbadk.widget.richText.a dVR;
    private TbImageView dVS;
    private TextView dVT;
    private TextView dVU;
    private TextView dVV;
    private TextView dVW;
    private final ThreadAchievementShareInfo dVk;
    private final ThreadAchievementShareInfo.ParamBean dVl;
    private final Context mContext;
    private final View mRoot;

    public b(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.normal_interaction_achievement, (ViewGroup) null);
        this.dVk = threadAchievementShareInfo;
        this.dVl = threadAchievementShareInfo.getParams();
        initUI();
        initData();
    }

    private void initData() {
        if (this.dVl.getContent() != null && this.dVl.getContent().size() != 0) {
            JSONArray jSONArray = new JSONArray();
            ThreadAchievementShareInfo.ContentBean contentBean = null;
            for (ThreadAchievementShareInfo.ContentBean contentBean2 : this.dVl.getContent()) {
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
            if (!TextUtils.isEmpty(this.dVl.getThread_title())) {
                this.afW.setText(this.dVl.getThread_title());
                this.afW.setVisibility(0);
                this.dVQ.setMaxLines(6);
            } else {
                ((LinearLayout.LayoutParams) this.dVQ.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds20);
                this.dVQ.setMaxLines(8);
            }
            this.dVQ.setTextEllipsize(TextUtils.TruncateAt.END);
            this.dVQ.setMinimumHeight(l.getDimens(this.mContext, R.dimen.tbds516));
            if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.dVl.getThread_type().contains(UgcUBCUtils.UGC_TYPE_PIC_BTN)) {
                this.dVS.setVisibility(0);
                this.dVS.setDefaultBgResource(R.color.transparent);
                this.dVS.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.dVS.setPlaceHolder(2);
                this.dVS.startLoad(contentBean.getSrc(), 10, false);
                if (!TextUtils.isEmpty(this.dVl.getThread_title())) {
                    this.dVQ.setVisibility(8);
                } else {
                    this.dVQ.setMaxLines(2);
                    this.dVQ.setTextEllipsize(TextUtils.TruncateAt.END);
                    this.dVQ.setLayoutStrategy(this.dVR);
                    this.dVQ.setMinimumHeight(l.getDimens(this.mContext, R.dimen.tbds0));
                }
            }
            this.dVQ.setText(TbRichTextView.a(this.mContext, jSONArray, false));
            this.dVW.setText(at.cV(this.dVl.getAgree_num()));
            this.dVT.setText(at.cV(this.dVl.getPost_num()));
        }
    }

    private void initUI() {
        this.dVT = (TextView) this.mRoot.findViewById(R.id.comment_num);
        this.dVU = (TextView) this.mRoot.findViewById(R.id.comment_desc);
        this.dVV = (TextView) this.mRoot.findViewById(R.id.praise_desc);
        this.dVW = (TextView) this.mRoot.findViewById(R.id.praise_num);
        this.afW = (TextView) this.mRoot.findViewById(R.id.thread_title);
        this.dVS = (TbImageView) this.mRoot.findViewById(R.id.main_img);
        this.dVQ = (TbRichTextView) this.mRoot.findViewById(R.id.rich_text);
        this.dVW.setTextColor(ap.getColor(R.color.cp_other_d));
        this.dVT.setTextColor(ap.getColor(R.color.cp_other_d));
        this.dVV.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.dVU.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.afW.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.dVR = new com.baidu.tbadk.widget.richText.a();
        this.dVR.rz(l.getDimens(this.mContext, R.dimen.tbds38));
        this.dVR.setTextSize(l.getDimens(this.mContext, R.dimen.tbds42));
        this.dVR.rD(l.getDimens(this.mContext, R.dimen.tbds23));
        this.dVR.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12), 1.0f);
        this.dVR.br(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.dVQ.setLayoutStrategy(this.dVR);
        this.dVQ.setTextColor(ap.getColor(R.color.cp_cont_b));
    }

    public View getView() {
        return this.mRoot;
    }
}
