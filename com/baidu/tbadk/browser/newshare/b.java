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
    private TextView ago;
    private TbRichTextView ehS;
    private com.baidu.tbadk.widget.richText.a ehT;
    private TbImageView ehU;
    private TextView ehV;
    private TextView ehW;
    private TextView ehX;
    private TextView ehY;
    private final ThreadAchievementShareInfo ehm;
    private final ThreadAchievementShareInfo.ParamBean ehn;
    private final Context mContext;
    private final View mRoot;

    public b(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.normal_interaction_achievement, (ViewGroup) null);
        this.ehm = threadAchievementShareInfo;
        this.ehn = threadAchievementShareInfo.getParams();
        initUI();
        initData();
    }

    private void initData() {
        if (this.ehn.getContent() != null && this.ehn.getContent().size() != 0) {
            JSONArray jSONArray = new JSONArray();
            ThreadAchievementShareInfo.ContentBean contentBean = null;
            for (ThreadAchievementShareInfo.ContentBean contentBean2 : this.ehn.getContent()) {
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
            if (!TextUtils.isEmpty(this.ehn.getThread_title())) {
                this.ago.setText(this.ehn.getThread_title());
                this.ago.setVisibility(0);
                this.ehS.setMaxLines(6);
            } else {
                ((LinearLayout.LayoutParams) this.ehS.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds20);
                this.ehS.setMaxLines(8);
            }
            this.ehS.setTextEllipsize(TextUtils.TruncateAt.END);
            this.ehS.setMinimumHeight(l.getDimens(this.mContext, R.dimen.tbds516));
            if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.ehn.getThread_type().contains(UgcUBCUtils.UGC_TYPE_PIC_BTN)) {
                this.ehU.setVisibility(0);
                this.ehU.setDefaultBgResource(R.color.transparent);
                this.ehU.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.ehU.setPlaceHolder(2);
                this.ehU.startLoad(contentBean.getSrc(), 10, false);
                if (!TextUtils.isEmpty(this.ehn.getThread_title())) {
                    this.ehS.setVisibility(8);
                } else {
                    this.ehS.setMaxLines(2);
                    this.ehS.setTextEllipsize(TextUtils.TruncateAt.END);
                    this.ehS.setLayoutStrategy(this.ehT);
                    this.ehS.setMinimumHeight(l.getDimens(this.mContext, R.dimen.tbds0));
                }
            }
            this.ehS.setText(TbRichTextView.a(this.mContext, jSONArray, false));
            this.ehY.setText(at.dd(this.ehn.getAgree_num()));
            this.ehV.setText(at.dd(this.ehn.getPost_num()));
        }
    }

    private void initUI() {
        this.ehV = (TextView) this.mRoot.findViewById(R.id.comment_num);
        this.ehW = (TextView) this.mRoot.findViewById(R.id.comment_desc);
        this.ehX = (TextView) this.mRoot.findViewById(R.id.praise_desc);
        this.ehY = (TextView) this.mRoot.findViewById(R.id.praise_num);
        this.ago = (TextView) this.mRoot.findViewById(R.id.thread_title);
        this.ehU = (TbImageView) this.mRoot.findViewById(R.id.main_img);
        this.ehS = (TbRichTextView) this.mRoot.findViewById(R.id.rich_text);
        this.ehY.setTextColor(ap.getColor(R.color.cp_other_d));
        this.ehV.setTextColor(ap.getColor(R.color.cp_other_d));
        this.ehX.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.ehW.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.ago.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.ehT = new com.baidu.tbadk.widget.richText.a();
        this.ehT.rX(l.getDimens(this.mContext, R.dimen.tbds38));
        this.ehT.setTextSize(l.getDimens(this.mContext, R.dimen.tbds42));
        this.ehT.sb(l.getDimens(this.mContext, R.dimen.tbds23));
        this.ehT.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12), 1.0f);
        this.ehT.bq(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.ehS.setLayoutStrategy(this.ehT);
        this.ehS.setTextColor(ap.getColor(R.color.cp_cont_b));
    }

    public View getView() {
        return this.mRoot;
    }
}
