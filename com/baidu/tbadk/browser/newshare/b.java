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
    private TextView aiu;
    private final ThreadAchievementShareInfo eJv;
    private final ThreadAchievementShareInfo.ParamBean eJw;
    private TbRichTextView eKb;
    private com.baidu.tbadk.widget.richText.a eKc;
    private TbImageView eKd;
    private TextView eKe;
    private TextView eKf;
    private TextView eKg;
    private TextView eKh;
    private final Context mContext;
    private final View mRoot;

    public b(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.normal_interaction_achievement, (ViewGroup) null);
        this.eJv = threadAchievementShareInfo;
        this.eJw = threadAchievementShareInfo.getParams();
        initUI();
        initData();
    }

    private void initData() {
        if (this.eJw.getContent() != null && this.eJw.getContent().size() != 0) {
            JSONArray jSONArray = new JSONArray();
            ThreadAchievementShareInfo.ContentBean contentBean = null;
            for (ThreadAchievementShareInfo.ContentBean contentBean2 : this.eJw.getContent()) {
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
            if (!TextUtils.isEmpty(this.eJw.getThread_title())) {
                this.aiu.setText(this.eJw.getThread_title());
                this.aiu.setVisibility(0);
                this.eKb.setMaxLines(6);
            } else {
                ((LinearLayout.LayoutParams) this.eKb.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds20);
                this.eKb.setMaxLines(8);
            }
            this.eKb.setTextEllipsize(TextUtils.TruncateAt.END);
            this.eKb.setMinimumHeight(l.getDimens(this.mContext, R.dimen.tbds516));
            if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.eJw.getThread_type().contains("pic")) {
                this.eKd.setVisibility(0);
                this.eKd.setDefaultBgResource(R.color.transparent);
                this.eKd.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.eKd.setPlaceHolder(2);
                this.eKd.startLoad(contentBean.getSrc(), 10, false);
                if (!TextUtils.isEmpty(this.eJw.getThread_title())) {
                    this.eKb.setVisibility(8);
                } else {
                    this.eKb.setMaxLines(2);
                    this.eKb.setTextEllipsize(TextUtils.TruncateAt.END);
                    this.eKb.setLayoutStrategy(this.eKc);
                    this.eKb.setMinimumHeight(l.getDimens(this.mContext, R.dimen.tbds0));
                }
            }
            this.eKb.setText(TbRichTextView.a(this.mContext, jSONArray, false));
            this.eKh.setText(au.eg(this.eJw.getAgree_num()));
            this.eKe.setText(au.eg(this.eJw.getPost_num()));
        }
    }

    private void initUI() {
        this.eKe = (TextView) this.mRoot.findViewById(R.id.comment_num);
        this.eKf = (TextView) this.mRoot.findViewById(R.id.comment_desc);
        this.eKg = (TextView) this.mRoot.findViewById(R.id.praise_desc);
        this.eKh = (TextView) this.mRoot.findViewById(R.id.praise_num);
        this.aiu = (TextView) this.mRoot.findViewById(R.id.thread_title);
        this.eKd = (TbImageView) this.mRoot.findViewById(R.id.main_img);
        this.eKb = (TbRichTextView) this.mRoot.findViewById(R.id.rich_text);
        this.eKh.setTextColor(ap.getColor(R.color.CAM_X0310));
        this.eKe.setTextColor(ap.getColor(R.color.CAM_X0310));
        this.eKg.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.eKf.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.aiu.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.eKc = new com.baidu.tbadk.widget.richText.a();
        this.eKc.sf(l.getDimens(this.mContext, R.dimen.tbds38));
        this.eKc.setTextSize(l.getDimens(this.mContext, R.dimen.tbds42));
        this.eKc.sj(l.getDimens(this.mContext, R.dimen.tbds23));
        this.eKc.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12), 1.0f);
        this.eKc.bo(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.eKb.setLayoutStrategy(this.eKc);
        this.eKb.setTextColor(ap.getColor(R.color.CAM_X0105));
    }

    public View getView() {
        return this.mRoot;
    }
}
