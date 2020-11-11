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
    private TextView agp;
    private final ThreadAchievementShareInfo evD;
    private final ThreadAchievementShareInfo.ParamBean evE;
    private TbRichTextView ewj;
    private com.baidu.tbadk.widget.richText.a ewk;
    private TbImageView ewl;
    private TextView ewm;
    private TextView ewn;
    private TextView ewo;
    private TextView ewp;
    private final Context mContext;
    private final View mRoot;

    public b(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.mContext = context;
        this.mRoot = LayoutInflater.from(context).inflate(R.layout.normal_interaction_achievement, (ViewGroup) null);
        this.evD = threadAchievementShareInfo;
        this.evE = threadAchievementShareInfo.getParams();
        initUI();
        initData();
    }

    private void initData() {
        if (this.evE.getContent() != null && this.evE.getContent().size() != 0) {
            JSONArray jSONArray = new JSONArray();
            ThreadAchievementShareInfo.ContentBean contentBean = null;
            for (ThreadAchievementShareInfo.ContentBean contentBean2 : this.evE.getContent()) {
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
            if (!TextUtils.isEmpty(this.evE.getThread_title())) {
                this.agp.setText(this.evE.getThread_title());
                this.agp.setVisibility(0);
                this.ewj.setMaxLines(6);
            } else {
                ((LinearLayout.LayoutParams) this.ewj.getLayoutParams()).topMargin = l.getDimens(this.mContext, R.dimen.tbds20);
                this.ewj.setMaxLines(8);
            }
            this.ewj.setTextEllipsize(TextUtils.TruncateAt.END);
            this.ewj.setMinimumHeight(l.getDimens(this.mContext, R.dimen.tbds516));
            if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.evE.getThread_type().contains(UgcUBCUtils.UGC_TYPE_PIC_BTN)) {
                this.ewl.setVisibility(0);
                this.ewl.setDefaultBgResource(R.color.transparent);
                this.ewl.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.ewl.setPlaceHolder(2);
                this.ewl.startLoad(contentBean.getSrc(), 10, false);
                if (!TextUtils.isEmpty(this.evE.getThread_title())) {
                    this.ewj.setVisibility(8);
                } else {
                    this.ewj.setMaxLines(2);
                    this.ewj.setTextEllipsize(TextUtils.TruncateAt.END);
                    this.ewj.setLayoutStrategy(this.ewk);
                    this.ewj.setMinimumHeight(l.getDimens(this.mContext, R.dimen.tbds0));
                }
            }
            this.ewj.setText(TbRichTextView.a(this.mContext, jSONArray, false));
            this.ewp.setText(at.dB(this.evE.getAgree_num()));
            this.ewm.setText(at.dB(this.evE.getPost_num()));
        }
    }

    private void initUI() {
        this.ewm = (TextView) this.mRoot.findViewById(R.id.comment_num);
        this.ewn = (TextView) this.mRoot.findViewById(R.id.comment_desc);
        this.ewo = (TextView) this.mRoot.findViewById(R.id.praise_desc);
        this.ewp = (TextView) this.mRoot.findViewById(R.id.praise_num);
        this.agp = (TextView) this.mRoot.findViewById(R.id.thread_title);
        this.ewl = (TbImageView) this.mRoot.findViewById(R.id.main_img);
        this.ewj = (TbRichTextView) this.mRoot.findViewById(R.id.rich_text);
        this.ewp.setTextColor(ap.getColor(R.color.cp_other_d));
        this.ewm.setTextColor(ap.getColor(R.color.cp_other_d));
        this.ewo.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.ewn.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.agp.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.ewk = new com.baidu.tbadk.widget.richText.a();
        this.ewk.ss(l.getDimens(this.mContext, R.dimen.tbds38));
        this.ewk.setTextSize(l.getDimens(this.mContext, R.dimen.tbds42));
        this.ewk.sw(l.getDimens(this.mContext, R.dimen.tbds23));
        this.ewk.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12), 1.0f);
        this.ewk.br(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.ewj.setLayoutStrategy(this.ewk);
        this.ewj.setTextColor(ap.getColor(R.color.cp_cont_b));
    }

    public View getView() {
        return this.mRoot;
    }
}
