package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.v;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.s;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class ThreadGodReplyLayout extends RelativeLayout implements View.OnClickListener {
    private static final int dWX = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
    private View.OnClickListener agP;
    private View.OnClickListener ags;
    private TextView agw;
    private boolean aha;
    private bk ahg;
    private int dEB;
    private AgreeView dVU;
    private TextView dWY;
    private PlayVoiceBntNew dWZ;
    private FrameLayout dXa;
    private TextView dXb;
    private ClickableHeaderImageView dXc;
    private PostData dXd;
    private TbRichTextVoiceInfo dXe;
    private int dXf;
    private final float dXg;
    private View.OnClickListener dXh;
    private Context mContext;
    private String mFrom;
    private List<TbRichTextImageInfo> mImageList;
    private RelativeLayout mRootView;
    private int mSkinType;
    private View mView;

    public ThreadGodReplyLayout(Context context) {
        super(context);
        this.ahg = null;
        this.mSkinType = 3;
        this.dXg = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.agP = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.dXd != null && ThreadGodReplyLayout.this.dXd.aQx() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.dXd.aQx().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.dXd.aQx().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.dXd.aQx().getUserId(), ThreadGodReplyLayout.this.dXd.aQx().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.dXd.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.ags != null) {
                        ThreadGodReplyLayout.this.ags.onClick(view);
                    }
                }
            }
        };
        this.dXh = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.ags != null) {
                    ThreadGodReplyLayout.this.ags.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahg = null;
        this.mSkinType = 3;
        this.dXg = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.agP = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.dXd != null && ThreadGodReplyLayout.this.dXd.aQx() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.dXd.aQx().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.dXd.aQx().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.dXd.aQx().getUserId(), ThreadGodReplyLayout.this.dXd.aQx().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.dXd.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.ags != null) {
                        ThreadGodReplyLayout.this.ags.onClick(view);
                    }
                }
            }
        };
        this.dXh = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.ags != null) {
                    ThreadGodReplyLayout.this.ags.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ahg = null;
        this.mSkinType = 3;
        this.dXg = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.agP = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.dXd != null && ThreadGodReplyLayout.this.dXd.aQx() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.dXd.aQx().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.dXd.aQx().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.dXd.aQx().getUserId(), ThreadGodReplyLayout.this.dXd.aQx().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.dXd.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.ags != null) {
                        ThreadGodReplyLayout.this.ags.onClick(view);
                    }
                }
            }
        };
        this.dXh = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.ags != null) {
                    ThreadGodReplyLayout.this.ags.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(R.layout.thread_god_reply_layout, (ViewGroup) this, true);
        this.mRootView = (RelativeLayout) this.mView.findViewById(R.id.god_comment_layout);
        this.dXc = (ClickableHeaderImageView) this.mView.findViewById(R.id.god_reply_user_pendant_header);
        this.dXc.setIsRound(true);
        this.dXc.setClickable(true);
        this.agw = (TextView) this.mView.findViewById(R.id.god_reply_username_text);
        this.agw.setOnClickListener(this.agP);
        this.dVU = (AgreeView) this.mView.findViewById(R.id.god_reply_agree_view);
        this.dVU.setAfterClickListener(this.dXh);
        this.dVU.setAgreeAlone(true);
        this.dWY = (TextView) this.mView.findViewById(R.id.god_reply_content);
        this.dWZ = (PlayVoiceBntNew) this.mView.findViewById(R.id.god_reply_voice_btn);
        this.dWZ.setVisibility(8);
        this.dXa = (FrameLayout) this.mView.findViewById(R.id.god_reply_image_layout);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
        this.dXf = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10);
        this.dEB = (((equipmentWidth - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (this.dXf * 4)) / 5;
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.dEB, this.dEB);
            layoutParams.leftMargin = (this.dEB + this.dXf) * i;
            this.dXa.addView(tbImageView, layoutParams);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(am.getColor(R.color.cp_border_a));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setTag(R.id.god_reply_image_layout, Integer.valueOf(i));
            tbImageView.setTagTextSize((int) getResources().getDimension(R.dimen.tbfontsize26));
            tbImageView.setTagPaddingDis(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6));
            tbImageView.setOnClickListener(this);
            tbImageView.setPlaceHolder(2);
        }
        this.dXa.setVisibility(8);
        this.dXb = (TextView) this.mView.findViewById(R.id.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.aha = z;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aWL() {
        if (this.dXc != null) {
            this.dXc.setPlaceHolder(1);
        }
        int childCount = this.dXa.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.dXa.getChildAt(i);
                if (childAt instanceof TbImageView) {
                    ((TbImageView) childAt).setPlaceHolder(2);
                }
            }
        }
    }

    public void setData(bk bkVar) {
        this.ahg = bkVar;
        setData(bkVar != null ? bkVar.aSb() : null);
    }

    public void setData(PostData postData) {
        if (postData == null || postData.aQx() == null || postData.aQx().getUserId() == null) {
            setVisibility(8);
            return;
        }
        this.dXd = postData;
        setVisibility(0);
        a(postData);
        a(a(postData.ddL()));
        b(postData);
        c(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.dXe != null && this.dXe.bjq() != null)) {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds30));
        } else {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds25));
        }
        if (!ba(this.dWY) && !ba(this.dXa) && !ba(this.dWZ)) {
            setVisibility(8);
        }
    }

    private void a(SpannableStringBuilder spannableStringBuilder) {
        float f;
        if (spannableStringBuilder == null || TextUtils.isEmpty(spannableStringBuilder.toString())) {
            this.dWY.setVisibility(8);
            return;
        }
        this.dWY.setVisibility(0);
        if (!v.a(this.dXg, this.dWY.getPaint(), spannableStringBuilder.toString(), 5)) {
            this.dWY.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else {
            final SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(R.string.text_expand_tail));
            if (spannableStringBuilder3.length() >= 3) {
                spannableStringBuilder3.setSpan(new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1
                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        s.bLs().e(new an("c13348"));
                        ThreadGodReplyLayout.this.dWY.setMaxLines(15);
                        ThreadGodReplyLayout.this.dWY.setEllipsize(TextUtils.TruncateAt.END);
                        ThreadGodReplyLayout.this.dWY.setText(spannableStringBuilder2.toString());
                        ThreadGodReplyLayout.this.dWY.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ThreadGodReplyLayout.this.dWY.getLineCount() >= 15) {
                                    ThreadGodReplyLayout.this.dWY.setText(((Object) ThreadGodReplyLayout.this.dWY.getText().subSequence(0, ThreadGodReplyLayout.this.dWY.getLayout().getLineEnd(14) - 1)) + StringHelper.STRING_MORE);
                                }
                            }
                        });
                    }
                }, 3, spannableStringBuilder3.length(), 17);
                StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.dWY.getPaint(), (int) this.dXg, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                float f2 = this.dXg;
                if (staticLayout.getLineCount() >= 5) {
                    spannableStringBuilder.delete(staticLayout.getLineEnd(4), spannableStringBuilder.length());
                    f = this.dXg - staticLayout.getLineWidth(4);
                } else {
                    f = f2;
                }
                CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                float measureText = this.dWY.getPaint().measureText(spannableStringBuilder3.toString());
                int i = 2;
                while (measureText > this.dWY.getPaint().measureText(subSequence.toString()) + f) {
                    i++;
                    if (spannableStringBuilder.length() - i < 0) {
                        break;
                    }
                    subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i, spannableStringBuilder.length());
                }
                if (spannableStringBuilder.length() - i > 0) {
                    spannableStringBuilder.replace(spannableStringBuilder.length() - i, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder3);
                }
                this.dWY.setText(spannableStringBuilder);
                this.dWY.setOnTouchListener(new com.baidu.tieba.view.i(spannableStringBuilder));
                s.bLs().e(new an("c13347"));
            } else {
                return;
            }
        }
        aWM();
    }

    private boolean ba(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData) {
        if (postData != null) {
            this.dXc.setData(postData.aQx());
            this.agw.setText(aq.cutChineseAndEnglishWithSuffix(postData.aQx().getName_show(), 14, StringHelper.STRING_MORE) + "：");
            if (this.ahg != null) {
                postData.aSp().threadId = this.ahg.getTid();
            }
            postData.aSp().threadId = String.valueOf(postData.getTid());
            postData.aSp().objType = 3;
            this.dVU.setData(postData.aSp());
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> bis;
        if (tbRichText == null || (bis = tbRichText.bis()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = bis.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.biz());
            } else if (next.getType() == 17) {
                String str = next.biD().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    spannableStringBuilder.append((CharSequence) "[表情]");
                }
            } else if (next.getType() == 20) {
                spannableStringBuilder.append((CharSequence) "[表情]");
            }
        }
        if (spannableStringBuilder.length() > 0) {
            for (com.baidu.tbadk.widget.richText.f fVar : (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length() - 1, com.baidu.tbadk.widget.richText.f.class)) {
                spannableStringBuilder.removeSpan(fVar);
            }
            for (ForegroundColorSpan foregroundColorSpan : (ForegroundColorSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length() - 1, ForegroundColorSpan.class)) {
                spannableStringBuilder.removeSpan(foregroundColorSpan);
            }
        }
        return spannableStringBuilder;
    }

    public void b(PostData postData) {
        if (this.mImageList == null) {
            this.mImageList = new ArrayList();
        } else {
            this.mImageList.clear();
        }
        if (!com.baidu.tbadk.core.k.aNQ().isShowImages()) {
            this.dXa.setVisibility(8);
            this.dXb.setVisibility(8);
            return;
        }
        TbRichText ddL = postData.ddL();
        if (ddL == null || ddL.bis() == null) {
            this.dXa.setVisibility(8);
            this.dXb.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = ddL.bis().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                next.bd(dWX, dWX);
                if (next.getType() == 8) {
                    this.mImageList.add(next.biy());
                }
            }
        }
        if (this.mImageList.size() == 0) {
            this.dXa.setVisibility(8);
            this.dXb.setVisibility(8);
            return;
        }
        this.dXa.setVisibility(0);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int i = 0;
        for (int i2 = 0; i2 < this.dXa.getChildCount(); i2++) {
            View childAt = this.dXa.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                TbImageView tbImageView = (TbImageView) childAt;
                tbImageView.bhs();
                tbImageView.setRadius(dimens);
                tbImageView.nM(15);
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.biL())) {
                        tbImageView.startLoad(tbRichTextImageInfo.biL(), this.aha ? 13 : 14, false);
                        tbImageView.setVisibility(0);
                        i++;
                    } else {
                        tbImageView.setVisibility(8);
                    }
                } else {
                    tbImageView.setVisibility(8);
                }
            }
            i = i;
        }
        if (this.mImageList.size() > 5) {
            ImageView imageView = new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.dEB, this.dEB);
            layoutParams.leftMargin = (this.dEB + this.dXf) * 4;
            this.dXa.addView(imageView, -1, layoutParams);
            imageView.setImageResource(R.drawable.shape_black_0_to_50_vertical);
            this.dXb.setVisibility(0);
            this.dXb.setText("+" + (this.mImageList.size() - 5));
            this.dXb.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    int dimens2 = com.baidu.adp.lib.util.l.getDimens(ThreadGodReplyLayout.this.getContext(), R.dimen.tbds26) + ((ThreadGodReplyLayout.this.dEB - ThreadGodReplyLayout.this.dXb.getWidth()) / 2);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ThreadGodReplyLayout.this.dXb.getLayoutParams();
                    layoutParams2.setMargins(0, dimens2, dimens2, 0);
                    ThreadGodReplyLayout.this.dXb.setLayoutParams(layoutParams2);
                }
            });
            return;
        }
        this.dXb.setVisibility(8);
    }

    public void c(PostData postData) {
        this.dXe = postData.biA();
        if (this.dXe == null) {
            this.dWZ.setVisibility(8);
            return;
        }
        this.dWZ.setVisibility(0);
        this.dWZ.setTag(this.dXe);
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            am.setViewTextColor(this.agw, (int) R.color.cp_cont_b);
            com.baidu.tbadk.core.util.e.a.aVw().lq(R.color.cp_bg_line_g).O(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10)).aR(this.mRootView);
            aWM();
            aWL();
            this.dVU.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.dWZ.crv();
        }
    }

    private void aWM() {
        m.a(this.dWY, this.ahg == null ? null : this.ahg.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
    }

    public TextView getGodReplyContent() {
        return this.dWY;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(R.id.god_reply_image_layout) != null && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(R.id.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.biI());
            }
            String str = "";
            String str2 = "";
            if (this.ahg != null) {
                str = this.ahg.aQC();
                str2 = this.ahg.getTid();
            }
            ImageViewerConfig createConfig = new ImageViewerConfig(getContext()).createConfig(arrayList, intValue, str, "", str2, true, arrayList.get(0), true);
            createConfig.getIntent().putExtra("from", this.mFrom);
            createConfig.getIntent().putExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, true);
            createConfig.setIsShowHost(false);
            createConfig.setThreadData(this.ahg);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            if (this.ags != null) {
                this.ags.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ags = onClickListener;
    }
}
