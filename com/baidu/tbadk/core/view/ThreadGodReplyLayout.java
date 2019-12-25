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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.card.r;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class ThreadGodReplyLayout extends RelativeLayout implements View.OnClickListener {
    private static final int ddT = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
    private TextView ME;
    private View.OnClickListener Mz;
    private View.OnClickListener Nb;
    private boolean Nf;
    private bj Nl;
    private int cMS;
    private AgreeView dcQ;
    private TextView ddU;
    private PlayVoiceBntNew ddV;
    private FrameLayout ddW;
    private TextView ddX;
    private ClickableHeaderImageView ddY;
    private PostData ddZ;
    private TbRichTextVoiceInfo dea;
    private int deb;
    private final float dec;
    private View.OnClickListener ded;
    private Context mContext;
    private String mFrom;
    private List<TbRichTextImageInfo> mImageList;
    private RelativeLayout mRootView;
    private int mSkinType;
    private View mView;

    public ThreadGodReplyLayout(Context context) {
        super(context);
        this.Nl = null;
        this.mSkinType = 3;
        this.dec = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.Nb = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.ddZ != null && ThreadGodReplyLayout.this.ddZ.azE() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.ddZ.azE().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.ddZ.azE().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.ddZ.azE().getUserId(), ThreadGodReplyLayout.this.ddZ.azE().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.ddZ.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.Mz != null) {
                        ThreadGodReplyLayout.this.Mz.onClick(view);
                    }
                }
            }
        };
        this.ded = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.Mz != null) {
                    ThreadGodReplyLayout.this.Mz.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Nl = null;
        this.mSkinType = 3;
        this.dec = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.Nb = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.ddZ != null && ThreadGodReplyLayout.this.ddZ.azE() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.ddZ.azE().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.ddZ.azE().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.ddZ.azE().getUserId(), ThreadGodReplyLayout.this.ddZ.azE().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.ddZ.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.Mz != null) {
                        ThreadGodReplyLayout.this.Mz.onClick(view);
                    }
                }
            }
        };
        this.ded = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.Mz != null) {
                    ThreadGodReplyLayout.this.Mz.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Nl = null;
        this.mSkinType = 3;
        this.dec = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.Nb = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.ddZ != null && ThreadGodReplyLayout.this.ddZ.azE() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.ddZ.azE().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.ddZ.azE().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.ddZ.azE().getUserId(), ThreadGodReplyLayout.this.ddZ.azE().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.ddZ.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.Mz != null) {
                        ThreadGodReplyLayout.this.Mz.onClick(view);
                    }
                }
            }
        };
        this.ded = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.Mz != null) {
                    ThreadGodReplyLayout.this.Mz.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(R.layout.thread_god_reply_layout, (ViewGroup) this, true);
        this.mRootView = (RelativeLayout) this.mView.findViewById(R.id.god_comment_layout);
        this.ddY = (ClickableHeaderImageView) this.mView.findViewById(R.id.god_reply_user_pendant_header);
        this.ddY.setIsRound(true);
        this.ddY.setClickable(true);
        this.ME = (TextView) this.mView.findViewById(R.id.god_reply_username_text);
        this.ME.setOnClickListener(this.Nb);
        this.dcQ = (AgreeView) this.mView.findViewById(R.id.god_reply_agree_view);
        this.dcQ.setAfterClickListener(this.ded);
        this.dcQ.setAgreeAlone(true);
        this.ddU = (TextView) this.mView.findViewById(R.id.god_reply_content);
        this.ddV = (PlayVoiceBntNew) this.mView.findViewById(R.id.god_reply_voice_btn);
        this.ddV.setVisibility(8);
        this.ddW = (FrameLayout) this.mView.findViewById(R.id.god_reply_image_layout);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
        this.deb = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10);
        this.cMS = (((equipmentWidth - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (this.deb * 4)) / 5;
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.cMS, this.cMS);
            layoutParams.leftMargin = (this.cMS + this.deb) * i;
            this.ddW.addView(tbImageView, layoutParams);
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
        this.ddW.setVisibility(8);
        this.ddX = (TextView) this.mView.findViewById(R.id.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.Nf = z;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aFu() {
        if (this.ddY != null) {
            this.ddY.setPlaceHolder(1);
        }
        int childCount = this.ddW.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.ddW.getChildAt(i);
                if (childAt instanceof TbImageView) {
                    ((TbImageView) childAt).setPlaceHolder(2);
                }
            }
        }
    }

    public void setData(bj bjVar) {
        this.Nl = bjVar;
        setData(bjVar != null ? bjVar.aBe() : null);
    }

    public void setData(PostData postData) {
        if (postData == null || postData.azE() == null || postData.azE().getUserId() == null) {
            setVisibility(8);
            return;
        }
        this.ddZ = postData;
        setVisibility(0);
        a(postData);
        a(a(postData.cIv()));
        b(postData);
        c(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.dea != null && this.dea.aSd() != null)) {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds30));
        } else {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds25));
        }
        if (!aU(this.ddU) && !aU(this.ddW) && !aU(this.ddV)) {
            setVisibility(8);
        }
    }

    private void a(SpannableStringBuilder spannableStringBuilder) {
        float f;
        if (spannableStringBuilder == null || TextUtils.isEmpty(spannableStringBuilder.toString())) {
            this.ddU.setVisibility(8);
            return;
        }
        this.ddU.setVisibility(0);
        if (!v.a(this.dec, this.ddU.getPaint(), spannableStringBuilder.toString(), 5)) {
            this.ddU.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else {
            final SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(R.string.text_expand_tail));
            if (spannableStringBuilder3.length() >= 3) {
                spannableStringBuilder3.setSpan(new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1
                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        r.bsy().c(new an("c13348"));
                        ThreadGodReplyLayout.this.ddU.setMaxLines(15);
                        ThreadGodReplyLayout.this.ddU.setEllipsize(TextUtils.TruncateAt.END);
                        ThreadGodReplyLayout.this.ddU.setText(spannableStringBuilder2.toString());
                        ThreadGodReplyLayout.this.ddU.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ThreadGodReplyLayout.this.ddU.getLineCount() >= 15) {
                                    ThreadGodReplyLayout.this.ddU.setText(((Object) ThreadGodReplyLayout.this.ddU.getText().subSequence(0, ThreadGodReplyLayout.this.ddU.getLayout().getLineEnd(14) - 1)) + StringHelper.STRING_MORE);
                                }
                            }
                        });
                    }
                }, 3, spannableStringBuilder3.length(), 17);
                StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.ddU.getPaint(), (int) this.dec, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                float f2 = this.dec;
                if (staticLayout.getLineCount() >= 5) {
                    spannableStringBuilder.delete(staticLayout.getLineEnd(4), spannableStringBuilder.length());
                    f = this.dec - staticLayout.getLineWidth(4);
                } else {
                    f = f2;
                }
                CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                float measureText = this.ddU.getPaint().measureText(spannableStringBuilder3.toString());
                int i = 2;
                while (measureText > this.ddU.getPaint().measureText(subSequence.toString()) + f) {
                    i++;
                    if (spannableStringBuilder.length() - i < 0) {
                        break;
                    }
                    subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i, spannableStringBuilder.length());
                }
                if (spannableStringBuilder.length() - i > 0) {
                    spannableStringBuilder.replace(spannableStringBuilder.length() - i, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder3);
                }
                this.ddU.setText(spannableStringBuilder);
                this.ddU.setOnTouchListener(new com.baidu.tieba.view.h(spannableStringBuilder));
                r.bsy().c(new an("c13347"));
            } else {
                return;
            }
        }
        aFv();
    }

    private boolean aU(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData) {
        if (postData != null) {
            this.ddY.setData(postData.azE());
            this.ME.setText(aq.cutChineseAndEnglishWithSuffix(postData.azE().getName_show(), 14, StringHelper.STRING_MORE) + "：");
            if (this.Nl != null) {
                postData.aBt().threadId = this.Nl.getTid();
            }
            postData.aBt().threadId = String.valueOf(postData.getTid());
            postData.aBt().objType = 3;
            this.dcQ.setData(postData.aBt());
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> aRf;
        if (tbRichText == null || (aRf = tbRichText.aRf()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = aRf.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.aRm());
            } else if (next.getType() == 17) {
                String str = next.aRq().mGifInfo.mSharpText;
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
        if (!com.baidu.tbadk.core.i.axf().isShowImages()) {
            this.ddW.setVisibility(8);
            this.ddX.setVisibility(8);
            return;
        }
        TbRichText cIv = postData.cIv();
        if (cIv == null || cIv.aRf() == null) {
            this.ddW.setVisibility(8);
            this.ddX.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = cIv.aRf().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                next.aQ(ddT, ddT);
                if (next.getType() == 8) {
                    this.mImageList.add(next.aRl());
                }
            }
        }
        if (this.mImageList.size() == 0) {
            this.ddW.setVisibility(8);
            this.ddX.setVisibility(8);
            return;
        }
        this.ddW.setVisibility(0);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int i = 0;
        for (int i2 = 0; i2 < this.ddW.getChildCount(); i2++) {
            View childAt = this.ddW.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                TbImageView tbImageView = (TbImageView) childAt;
                tbImageView.aQg();
                tbImageView.setRadius(dimens);
                tbImageView.mD(15);
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.aRz())) {
                        tbImageView.startLoad(tbRichTextImageInfo.aRz(), this.Nf ? 13 : 14, false);
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
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.cMS, this.cMS);
            layoutParams.leftMargin = (this.cMS + this.deb) * 4;
            this.ddW.addView(imageView, -1, layoutParams);
            imageView.setImageResource(R.drawable.shape_black_0_to_50_vertical);
            this.ddX.setVisibility(0);
            this.ddX.setText("+" + (this.mImageList.size() - 5));
            this.ddX.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    int dimens2 = com.baidu.adp.lib.util.l.getDimens(ThreadGodReplyLayout.this.getContext(), R.dimen.tbds26) + ((ThreadGodReplyLayout.this.cMS - ThreadGodReplyLayout.this.ddX.getWidth()) / 2);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ThreadGodReplyLayout.this.ddX.getLayoutParams();
                    layoutParams2.setMargins(0, dimens2, dimens2, 0);
                    ThreadGodReplyLayout.this.ddX.setLayoutParams(layoutParams2);
                }
            });
            return;
        }
        this.ddX.setVisibility(8);
    }

    public void c(PostData postData) {
        this.dea = postData.aRn();
        if (this.dea == null) {
            this.ddV.setVisibility(8);
            return;
        }
        this.ddV.setVisibility(0);
        this.ddV.setTag(this.dea);
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            am.setViewTextColor(this.ME, (int) R.color.cp_cont_b);
            com.baidu.tbadk.core.util.f.a.aEt().kl(R.color.cp_bg_line_g).ah(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10)).aM(this.mRootView);
            aFv();
            aFu();
            this.dcQ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.ddV.bEM();
        }
    }

    private void aFv() {
        com.baidu.tieba.card.l.a(this.ddU, this.Nl == null ? null : this.Nl.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
    }

    public TextView getGodReplyContent() {
        return this.ddU;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(R.id.god_reply_image_layout) != null && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(R.id.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.aRw());
            }
            String str = "";
            String str2 = "";
            if (this.Nl != null) {
                str = this.Nl.azJ();
                str2 = this.Nl.getTid();
            }
            ImageViewerConfig createConfig = new ImageViewerConfig(getContext()).createConfig(arrayList, intValue, str, "", str2, true, arrayList.get(0), true);
            createConfig.getIntent().putExtra("from", this.mFrom);
            createConfig.getIntent().putExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, true);
            createConfig.setIsShowHost(false);
            createConfig.setThreadData(this.Nl);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            if (this.Mz != null) {
                this.Mz.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.Mz = onClickListener;
    }
}
