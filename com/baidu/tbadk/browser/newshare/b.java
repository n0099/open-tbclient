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
    private TextView agu;
    private final ThreadAchievementShareInfo etU;
    private final ThreadAchievementShareInfo.ParamBean etV;
    private TbRichTextView euA;
    private com.baidu.tbadk.widget.richText.a euB;
    private TbImageView euC;
    private TextView euD;
    private TextView euE;
    private TextView euF;
    private TextView euG;
    private final Context mContext;
    private final View mRoot;

    public b(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.normal_interaction_achievement, (ViewGroup) null);
        this.etU = threadAchievementShareInfo;
        this.etV = threadAchievementShareInfo.getParams();
        initUI();
        initData();
    }

    private void initData() {
        if (this.etV.getContent() != null && this.etV.getContent().size() != 0) {
            JSONArray jSONArray = new JSONArray();
            ThreadAchievementShareInfo.ContentBean contentBean = null;
            for (ThreadAchievementShareInfo.ContentBean contentBean2 : this.etV.getContent()) {
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
            if (!TextUtils.isEmpty(this.etV.getThread_title())) {
                this.agu.setText(this.etV.getThread_title());
                this.agu.setVisibility(0);
                this.euA.setMaxLines(6);
            } else {
                ((LinearLayout.LayoutParams) this.euA.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds20);
                this.euA.setMaxLines(8);
            }
            this.euA.setTextEllipsize(TextUtils.TruncateAt.END);
            this.euA.setMinimumHeight(l.getDimens(this.mContext, R.dimen.tbds516));
            if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.etV.getThread_type().contains(UgcUBCUtils.UGC_TYPE_PIC_BTN)) {
                this.euC.setVisibility(0);
                this.euC.setDefaultBgResource(R.color.transparent);
                this.euC.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.euC.setPlaceHolder(2);
                this.euC.startLoad(contentBean.getSrc(), 10, false);
                if (!TextUtils.isEmpty(this.etV.getThread_title())) {
                    this.euA.setVisibility(8);
                } else {
                    this.euA.setMaxLines(2);
                    this.euA.setTextEllipsize(TextUtils.TruncateAt.END);
                    this.euA.setLayoutStrategy(this.euB);
                    this.euA.setMinimumHeight(l.getDimens(this.mContext, R.dimen.tbds0));
                }
            }
            this.euA.setText(TbRichTextView.a(this.mContext, jSONArray, false));
            this.euG.setText(au.dB(this.etV.getAgree_num()));
            this.euD.setText(au.dB(this.etV.getPost_num()));
        }
    }

    private void initUI() {
        this.euD = (TextView) this.mRoot.findViewById(R.id.comment_num);
        this.euE = (TextView) this.mRoot.findViewById(R.id.comment_desc);
        this.euF = (TextView) this.mRoot.findViewById(R.id.praise_desc);
        this.euG = (TextView) this.mRoot.findViewById(R.id.praise_num);
        this.agu = (TextView) this.mRoot.findViewById(R.id.thread_title);
        this.euC = (TbImageView) this.mRoot.findViewById(R.id.main_img);
        this.euA = (TbRichTextView) this.mRoot.findViewById(R.id.rich_text);
        this.euG.setTextColor(ap.getColor(R.color.CAM_X0310));
        this.euD.setTextColor(ap.getColor(R.color.CAM_X0310));
        this.euF.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.euE.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.agu.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.euB = new com.baidu.tbadk.widget.richText.a();
        this.euB.sQ(l.getDimens(this.mContext, R.dimen.tbds38));
        this.euB.setTextSize(l.getDimens(this.mContext, R.dimen.tbds42));
        this.euB.sU(l.getDimens(this.mContext, R.dimen.tbds23));
        this.euB.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12), 1.0f);
        this.euB.br(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.euA.setLayoutStrategy(this.euB);
        this.euA.setTextColor(ap.getColor(R.color.CAM_X0105));
    }

    public View getView() {
        return this.mRoot;
    }
}
