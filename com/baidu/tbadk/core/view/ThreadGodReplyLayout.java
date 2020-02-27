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
/* loaded from: classes8.dex */
public class ThreadGodReplyLayout extends RelativeLayout implements View.OnClickListener {
    private static final int dii = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
    private View.OnClickListener NG;
    private boolean NJ;
    private bj NQ;
    private View.OnClickListener Nh;
    private TextView Nl;
    private int cRf;
    private AgreeView dhf;
    private TextView dij;
    private PlayVoiceBntNew dik;
    private FrameLayout dil;
    private TextView dim;
    private ClickableHeaderImageView din;
    private PostData dio;
    private TbRichTextVoiceInfo dip;
    private int diq;
    private final float dit;
    private View.OnClickListener diu;
    private Context mContext;
    private String mFrom;
    private List<TbRichTextImageInfo> mImageList;
    private RelativeLayout mRootView;
    private int mSkinType;
    private View mView;

    public ThreadGodReplyLayout(Context context) {
        super(context);
        this.NQ = null;
        this.mSkinType = 3;
        this.dit = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.NG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.dio != null && ThreadGodReplyLayout.this.dio.aCm() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.dio.aCm().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.dio.aCm().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.dio.aCm().getUserId(), ThreadGodReplyLayout.this.dio.aCm().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.dio.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.Nh != null) {
                        ThreadGodReplyLayout.this.Nh.onClick(view);
                    }
                }
            }
        };
        this.diu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.Nh != null) {
                    ThreadGodReplyLayout.this.Nh.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.NQ = null;
        this.mSkinType = 3;
        this.dit = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.NG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.dio != null && ThreadGodReplyLayout.this.dio.aCm() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.dio.aCm().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.dio.aCm().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.dio.aCm().getUserId(), ThreadGodReplyLayout.this.dio.aCm().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.dio.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.Nh != null) {
                        ThreadGodReplyLayout.this.Nh.onClick(view);
                    }
                }
            }
        };
        this.diu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.Nh != null) {
                    ThreadGodReplyLayout.this.Nh.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.NQ = null;
        this.mSkinType = 3;
        this.dit = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.NG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.dio != null && ThreadGodReplyLayout.this.dio.aCm() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.dio.aCm().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.dio.aCm().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.dio.aCm().getUserId(), ThreadGodReplyLayout.this.dio.aCm().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.dio.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.Nh != null) {
                        ThreadGodReplyLayout.this.Nh.onClick(view);
                    }
                }
            }
        };
        this.diu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.Nh != null) {
                    ThreadGodReplyLayout.this.Nh.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(R.layout.thread_god_reply_layout, (ViewGroup) this, true);
        this.mRootView = (RelativeLayout) this.mView.findViewById(R.id.god_comment_layout);
        this.din = (ClickableHeaderImageView) this.mView.findViewById(R.id.god_reply_user_pendant_header);
        this.din.setIsRound(true);
        this.din.setClickable(true);
        this.Nl = (TextView) this.mView.findViewById(R.id.god_reply_username_text);
        this.Nl.setOnClickListener(this.NG);
        this.dhf = (AgreeView) this.mView.findViewById(R.id.god_reply_agree_view);
        this.dhf.setAfterClickListener(this.diu);
        this.dhf.setAgreeAlone(true);
        this.dij = (TextView) this.mView.findViewById(R.id.god_reply_content);
        this.dik = (PlayVoiceBntNew) this.mView.findViewById(R.id.god_reply_voice_btn);
        this.dik.setVisibility(8);
        this.dil = (FrameLayout) this.mView.findViewById(R.id.god_reply_image_layout);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
        this.diq = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10);
        this.cRf = (((equipmentWidth - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (this.diq * 4)) / 5;
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.cRf, this.cRf);
            layoutParams.leftMargin = (this.cRf + this.diq) * i;
            this.dil.addView(tbImageView, layoutParams);
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
        this.dil.setVisibility(8);
        this.dim = (TextView) this.mView.findViewById(R.id.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.NJ = z;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aIc() {
        if (this.din != null) {
            this.din.setPlaceHolder(1);
        }
        int childCount = this.dil.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.dil.getChildAt(i);
                if (childAt instanceof TbImageView) {
                    ((TbImageView) childAt).setPlaceHolder(2);
                }
            }
        }
    }

    public void setData(bj bjVar) {
        this.NQ = bjVar;
        setData(bjVar != null ? bjVar.aDK() : null);
    }

    public void setData(PostData postData) {
        if (postData == null || postData.aCm() == null || postData.aCm().getUserId() == null) {
            setVisibility(8);
            return;
        }
        this.dio = postData;
        setVisibility(0);
        a(postData);
        a(a(postData.cLa()));
        b(postData);
        c(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.dip != null && this.dip.aUO() != null)) {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds30));
        } else {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds25));
        }
        if (!aY(this.dij) && !aY(this.dil) && !aY(this.dik)) {
            setVisibility(8);
        }
    }

    private void a(SpannableStringBuilder spannableStringBuilder) {
        float f;
        if (spannableStringBuilder == null || TextUtils.isEmpty(spannableStringBuilder.toString())) {
            this.dij.setVisibility(8);
            return;
        }
        this.dij.setVisibility(0);
        if (!v.a(this.dit, this.dij.getPaint(), spannableStringBuilder.toString(), 5)) {
            this.dij.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else {
            final SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(R.string.text_expand_tail));
            if (spannableStringBuilder3.length() >= 3) {
                spannableStringBuilder3.setSpan(new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1
                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        r.bve().d(new an("c13348"));
                        ThreadGodReplyLayout.this.dij.setMaxLines(15);
                        ThreadGodReplyLayout.this.dij.setEllipsize(TextUtils.TruncateAt.END);
                        ThreadGodReplyLayout.this.dij.setText(spannableStringBuilder2.toString());
                        ThreadGodReplyLayout.this.dij.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ThreadGodReplyLayout.this.dij.getLineCount() >= 15) {
                                    ThreadGodReplyLayout.this.dij.setText(((Object) ThreadGodReplyLayout.this.dij.getText().subSequence(0, ThreadGodReplyLayout.this.dij.getLayout().getLineEnd(14) - 1)) + StringHelper.STRING_MORE);
                                }
                            }
                        });
                    }
                }, 3, spannableStringBuilder3.length(), 17);
                StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.dij.getPaint(), (int) this.dit, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                float f2 = this.dit;
                if (staticLayout.getLineCount() >= 5) {
                    spannableStringBuilder.delete(staticLayout.getLineEnd(4), spannableStringBuilder.length());
                    f = this.dit - staticLayout.getLineWidth(4);
                } else {
                    f = f2;
                }
                CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                float measureText = this.dij.getPaint().measureText(spannableStringBuilder3.toString());
                int i = 2;
                while (measureText > this.dij.getPaint().measureText(subSequence.toString()) + f) {
                    i++;
                    if (spannableStringBuilder.length() - i < 0) {
                        break;
                    }
                    subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i, spannableStringBuilder.length());
                }
                if (spannableStringBuilder.length() - i > 0) {
                    spannableStringBuilder.replace(spannableStringBuilder.length() - i, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder3);
                }
                this.dij.setText(spannableStringBuilder);
                this.dij.setOnTouchListener(new com.baidu.tieba.view.h(spannableStringBuilder));
                r.bve().d(new an("c13347"));
            } else {
                return;
            }
        }
        aId();
    }

    private boolean aY(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData) {
        if (postData != null) {
            this.din.setData(postData.aCm());
            this.Nl.setText(aq.cutChineseAndEnglishWithSuffix(postData.aCm().getName_show(), 14, StringHelper.STRING_MORE) + "：");
            if (this.NQ != null) {
                postData.aDY().threadId = this.NQ.getTid();
            }
            postData.aDY().threadId = String.valueOf(postData.getTid());
            postData.aDY().objType = 3;
            this.dhf.setData(postData.aDY());
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> aTQ;
        if (tbRichText == null || (aTQ = tbRichText.aTQ()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = aTQ.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.aTX());
            } else if (next.getType() == 17) {
                String str = next.aUb().mGifInfo.mSharpText;
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
        if (!com.baidu.tbadk.core.i.azM().isShowImages()) {
            this.dil.setVisibility(8);
            this.dim.setVisibility(8);
            return;
        }
        TbRichText cLa = postData.cLa();
        if (cLa == null || cLa.aTQ() == null) {
            this.dil.setVisibility(8);
            this.dim.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = cLa.aTQ().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                next.aU(dii, dii);
                if (next.getType() == 8) {
                    this.mImageList.add(next.aTW());
                }
            }
        }
        if (this.mImageList.size() == 0) {
            this.dil.setVisibility(8);
            this.dim.setVisibility(8);
            return;
        }
        this.dil.setVisibility(0);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int i = 0;
        for (int i2 = 0; i2 < this.dil.getChildCount(); i2++) {
            View childAt = this.dil.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                TbImageView tbImageView = (TbImageView) childAt;
                tbImageView.aSQ();
                tbImageView.setRadius(dimens);
                tbImageView.mU(15);
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.aUj())) {
                        tbImageView.startLoad(tbRichTextImageInfo.aUj(), this.NJ ? 13 : 14, false);
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
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.cRf, this.cRf);
            layoutParams.leftMargin = (this.cRf + this.diq) * 4;
            this.dil.addView(imageView, -1, layoutParams);
            imageView.setImageResource(R.drawable.shape_black_0_to_50_vertical);
            this.dim.setVisibility(0);
            this.dim.setText("+" + (this.mImageList.size() - 5));
            this.dim.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    int dimens2 = com.baidu.adp.lib.util.l.getDimens(ThreadGodReplyLayout.this.getContext(), R.dimen.tbds26) + ((ThreadGodReplyLayout.this.cRf - ThreadGodReplyLayout.this.dim.getWidth()) / 2);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ThreadGodReplyLayout.this.dim.getLayoutParams();
                    layoutParams2.setMargins(0, dimens2, dimens2, 0);
                    ThreadGodReplyLayout.this.dim.setLayoutParams(layoutParams2);
                }
            });
            return;
        }
        this.dim.setVisibility(8);
    }

    public void c(PostData postData) {
        this.dip = postData.aTY();
        if (this.dip == null) {
            this.dik.setVisibility(8);
            return;
        }
        this.dik.setVisibility(0);
        this.dik.setTag(this.dip);
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            am.setViewTextColor(this.Nl, (int) R.color.cp_cont_b);
            com.baidu.tbadk.core.util.f.a.aGY().kC(R.color.cp_bg_line_g).af(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10)).aQ(this.mRootView);
            aId();
            aIc();
            this.dhf.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.dik.bHq();
        }
    }

    private void aId() {
        com.baidu.tieba.card.l.a(this.dij, this.NQ == null ? null : this.NQ.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
    }

    public TextView getGodReplyContent() {
        return this.dij;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(R.id.god_reply_image_layout) != null && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(R.id.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.aUg());
            }
            String str = "";
            String str2 = "";
            if (this.NQ != null) {
                str = this.NQ.aCr();
                str2 = this.NQ.getTid();
            }
            ImageViewerConfig createConfig = new ImageViewerConfig(getContext()).createConfig(arrayList, intValue, str, "", str2, true, arrayList.get(0), true);
            createConfig.getIntent().putExtra("from", this.mFrom);
            createConfig.getIntent().putExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, true);
            createConfig.setIsShowHost(false);
            createConfig.setThreadData(this.NQ);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            if (this.Nh != null) {
                this.Nh.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.Nh = onClickListener;
    }
}
