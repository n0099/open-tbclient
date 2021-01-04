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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private TextView aif;
    private final ThreadAchievementShareInfo.ParamBean eKA;
    private final ThreadAchievementShareInfo eKz;
    private TbRichTextView eLf;
    private com.baidu.tbadk.widget.richText.a eLg;
    private TbImageView eLh;
    private TextView eLi;
    private TextView eLj;
    private TextView eLk;
    private TextView eLl;
    private final Context mContext;
    private final View mRoot;

    public b(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.normal_interaction_achievement, (ViewGroup) null);
        this.eKz = threadAchievementShareInfo;
        this.eKA = threadAchievementShareInfo.getParams();
        initUI();
        initData();
    }

    private void initData() {
        if (this.eKA.getContent() != null && this.eKA.getContent().size() != 0) {
            JSONArray jSONArray = new JSONArray();
            ThreadAchievementShareInfo.ContentBean contentBean = null;
            for (ThreadAchievementShareInfo.ContentBean contentBean2 : this.eKA.getContent()) {
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
            if (!TextUtils.isEmpty(this.eKA.getThread_title())) {
                this.aif.setText(this.eKA.getThread_title());
                this.aif.setVisibility(0);
                this.eLf.setMaxLines(6);
            } else {
                ((LinearLayout.LayoutParams) this.eLf.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds20);
                this.eLf.setMaxLines(8);
            }
            this.eLf.setTextEllipsize(TextUtils.TruncateAt.END);
            this.eLf.setMinimumHeight(l.getDimens(this.mContext, R.dimen.tbds516));
            if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.eKA.getThread_type().contains("pic")) {
                this.eLh.setVisibility(0);
                this.eLh.setDefaultBgResource(R.color.transparent);
                this.eLh.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.eLh.setPlaceHolder(2);
                this.eLh.startLoad(contentBean.getSrc(), 10, false);
                if (!TextUtils.isEmpty(this.eKA.getThread_title())) {
                    this.eLf.setVisibility(8);
                } else {
                    this.eLf.setMaxLines(2);
                    this.eLf.setTextEllipsize(TextUtils.TruncateAt.END);
                    this.eLf.setLayoutStrategy(this.eLg);
                    this.eLf.setMinimumHeight(l.getDimens(this.mContext, R.dimen.tbds0));
                }
            }
            this.eLf.setText(TbRichTextView.a(this.mContext, jSONArray, false));
            this.eLl.setText(at.ea(this.eKA.getAgree_num()));
            this.eLi.setText(at.ea(this.eKA.getPost_num()));
        }
    }

    private void initUI() {
        this.eLi = (TextView) this.mRoot.findViewById(R.id.comment_num);
        this.eLj = (TextView) this.mRoot.findViewById(R.id.comment_desc);
        this.eLk = (TextView) this.mRoot.findViewById(R.id.praise_desc);
        this.eLl = (TextView) this.mRoot.findViewById(R.id.praise_num);
        this.aif = (TextView) this.mRoot.findViewById(R.id.thread_title);
        this.eLh = (TbImageView) this.mRoot.findViewById(R.id.main_img);
        this.eLf = (TbRichTextView) this.mRoot.findViewById(R.id.rich_text);
        this.eLl.setTextColor(ao.getColor(R.color.CAM_X0310));
        this.eLi.setTextColor(ao.getColor(R.color.CAM_X0310));
        this.eLk.setTextColor(ao.getColor(R.color.CAM_X0105));
        this.eLj.setTextColor(ao.getColor(R.color.CAM_X0105));
        this.aif.setTextColor(ao.getColor(R.color.CAM_X0105));
        this.eLg = new com.baidu.tbadk.widget.richText.a();
        this.eLg.tE(l.getDimens(this.mContext, R.dimen.tbds38));
        this.eLg.setTextSize(l.getDimens(this.mContext, R.dimen.tbds42));
        this.eLg.tI(l.getDimens(this.mContext, R.dimen.tbds23));
        this.eLg.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12), 1.0f);
        this.eLg.br(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.eLf.setLayoutStrategy(this.eLg);
        this.eLf.setTextColor(ao.getColor(R.color.CAM_X0105));
    }

    public View getView() {
        return this.mRoot;
    }
}
