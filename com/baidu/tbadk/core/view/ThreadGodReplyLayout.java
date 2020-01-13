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
/* loaded from: classes6.dex */
public class ThreadGodReplyLayout extends RelativeLayout implements View.OnClickListener {
    private static final int ded = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
    private View.OnClickListener MG;
    private TextView MK;
    private View.OnClickListener Ng;
    private boolean Nj;
    private bj Np;
    private int cNc;
    private AgreeView dda;
    private TextView dee;
    private PlayVoiceBntNew def;
    private FrameLayout deg;
    private TextView deh;
    private ClickableHeaderImageView dei;
    private PostData dej;
    private TbRichTextVoiceInfo dek;
    private int del;
    private final float dem;
    private View.OnClickListener den;
    private Context mContext;
    private String mFrom;
    private List<TbRichTextImageInfo> mImageList;
    private RelativeLayout mRootView;
    private int mSkinType;
    private View mView;

    public ThreadGodReplyLayout(Context context) {
        super(context);
        this.Np = null;
        this.mSkinType = 3;
        this.dem = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.Ng = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.dej != null && ThreadGodReplyLayout.this.dej.azX() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.dej.azX().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.dej.azX().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.dej.azX().getUserId(), ThreadGodReplyLayout.this.dej.azX().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.dej.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.MG != null) {
                        ThreadGodReplyLayout.this.MG.onClick(view);
                    }
                }
            }
        };
        this.den = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.MG != null) {
                    ThreadGodReplyLayout.this.MG.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Np = null;
        this.mSkinType = 3;
        this.dem = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.Ng = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.dej != null && ThreadGodReplyLayout.this.dej.azX() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.dej.azX().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.dej.azX().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.dej.azX().getUserId(), ThreadGodReplyLayout.this.dej.azX().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.dej.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.MG != null) {
                        ThreadGodReplyLayout.this.MG.onClick(view);
                    }
                }
            }
        };
        this.den = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.MG != null) {
                    ThreadGodReplyLayout.this.MG.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Np = null;
        this.mSkinType = 3;
        this.dem = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.Ng = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.dej != null && ThreadGodReplyLayout.this.dej.azX() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.dej.azX().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.dej.azX().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.dej.azX().getUserId(), ThreadGodReplyLayout.this.dej.azX().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.dej.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.MG != null) {
                        ThreadGodReplyLayout.this.MG.onClick(view);
                    }
                }
            }
        };
        this.den = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.MG != null) {
                    ThreadGodReplyLayout.this.MG.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(R.layout.thread_god_reply_layout, (ViewGroup) this, true);
        this.mRootView = (RelativeLayout) this.mView.findViewById(R.id.god_comment_layout);
        this.dei = (ClickableHeaderImageView) this.mView.findViewById(R.id.god_reply_user_pendant_header);
        this.dei.setIsRound(true);
        this.dei.setClickable(true);
        this.MK = (TextView) this.mView.findViewById(R.id.god_reply_username_text);
        this.MK.setOnClickListener(this.Ng);
        this.dda = (AgreeView) this.mView.findViewById(R.id.god_reply_agree_view);
        this.dda.setAfterClickListener(this.den);
        this.dda.setAgreeAlone(true);
        this.dee = (TextView) this.mView.findViewById(R.id.god_reply_content);
        this.def = (PlayVoiceBntNew) this.mView.findViewById(R.id.god_reply_voice_btn);
        this.def.setVisibility(8);
        this.deg = (FrameLayout) this.mView.findViewById(R.id.god_reply_image_layout);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
        this.del = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10);
        this.cNc = (((equipmentWidth - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (this.del * 4)) / 5;
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.cNc, this.cNc);
            layoutParams.leftMargin = (this.cNc + this.del) * i;
            this.deg.addView(tbImageView, layoutParams);
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
        this.deg.setVisibility(8);
        this.deh = (TextView) this.mView.findViewById(R.id.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.Nj = z;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aFN() {
        if (this.dei != null) {
            this.dei.setPlaceHolder(1);
        }
        int childCount = this.deg.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.deg.getChildAt(i);
                if (childAt instanceof TbImageView) {
                    ((TbImageView) childAt).setPlaceHolder(2);
                }
            }
        }
    }

    public void setData(bj bjVar) {
        this.Np = bjVar;
        setData(bjVar != null ? bjVar.aBx() : null);
    }

    public void setData(PostData postData) {
        if (postData == null || postData.azX() == null || postData.azX().getUserId() == null) {
            setVisibility(8);
            return;
        }
        this.dej = postData;
        setVisibility(0);
        a(postData);
        a(a(postData.cJz()));
        b(postData);
        c(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.dek != null && this.dek.aSx() != null)) {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds30));
        } else {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds25));
        }
        if (!aY(this.dee) && !aY(this.deg) && !aY(this.def)) {
            setVisibility(8);
        }
    }

    private void a(SpannableStringBuilder spannableStringBuilder) {
        float f;
        if (spannableStringBuilder == null || TextUtils.isEmpty(spannableStringBuilder.toString())) {
            this.dee.setVisibility(8);
            return;
        }
        this.dee.setVisibility(0);
        if (!v.a(this.dem, this.dee.getPaint(), spannableStringBuilder.toString(), 5)) {
            this.dee.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else {
            final SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(R.string.text_expand_tail));
            if (spannableStringBuilder3.length() >= 3) {
                spannableStringBuilder3.setSpan(new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1
                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        r.btA().c(new an("c13348"));
                        ThreadGodReplyLayout.this.dee.setMaxLines(15);
                        ThreadGodReplyLayout.this.dee.setEllipsize(TextUtils.TruncateAt.END);
                        ThreadGodReplyLayout.this.dee.setText(spannableStringBuilder2.toString());
                        ThreadGodReplyLayout.this.dee.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ThreadGodReplyLayout.this.dee.getLineCount() >= 15) {
                                    ThreadGodReplyLayout.this.dee.setText(((Object) ThreadGodReplyLayout.this.dee.getText().subSequence(0, ThreadGodReplyLayout.this.dee.getLayout().getLineEnd(14) - 1)) + StringHelper.STRING_MORE);
                                }
                            }
                        });
                    }
                }, 3, spannableStringBuilder3.length(), 17);
                StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.dee.getPaint(), (int) this.dem, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                float f2 = this.dem;
                if (staticLayout.getLineCount() >= 5) {
                    spannableStringBuilder.delete(staticLayout.getLineEnd(4), spannableStringBuilder.length());
                    f = this.dem - staticLayout.getLineWidth(4);
                } else {
                    f = f2;
                }
                CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                float measureText = this.dee.getPaint().measureText(spannableStringBuilder3.toString());
                int i = 2;
                while (measureText > this.dee.getPaint().measureText(subSequence.toString()) + f) {
                    i++;
                    if (spannableStringBuilder.length() - i < 0) {
                        break;
                    }
                    subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i, spannableStringBuilder.length());
                }
                if (spannableStringBuilder.length() - i > 0) {
                    spannableStringBuilder.replace(spannableStringBuilder.length() - i, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder3);
                }
                this.dee.setText(spannableStringBuilder);
                this.dee.setOnTouchListener(new com.baidu.tieba.view.h(spannableStringBuilder));
                r.btA().c(new an("c13347"));
            } else {
                return;
            }
        }
        aFO();
    }

    private boolean aY(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData) {
        if (postData != null) {
            this.dei.setData(postData.azX());
            this.MK.setText(aq.cutChineseAndEnglishWithSuffix(postData.azX().getName_show(), 14, StringHelper.STRING_MORE) + "：");
            if (this.Np != null) {
                postData.aBM().threadId = this.Np.getTid();
            }
            postData.aBM().threadId = String.valueOf(postData.getTid());
            postData.aBM().objType = 3;
            this.dda.setData(postData.aBM());
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> aRz;
        if (tbRichText == null || (aRz = tbRichText.aRz()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = aRz.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.aRG());
            } else if (next.getType() == 17) {
                String str = next.aRK().mGifInfo.mSharpText;
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
        if (!com.baidu.tbadk.core.i.axy().isShowImages()) {
            this.deg.setVisibility(8);
            this.deh.setVisibility(8);
            return;
        }
        TbRichText cJz = postData.cJz();
        if (cJz == null || cJz.aRz() == null) {
            this.deg.setVisibility(8);
            this.deh.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = cJz.aRz().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                next.aU(ded, ded);
                if (next.getType() == 8) {
                    this.mImageList.add(next.aRF());
                }
            }
        }
        if (this.mImageList.size() == 0) {
            this.deg.setVisibility(8);
            this.deh.setVisibility(8);
            return;
        }
        this.deg.setVisibility(0);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int i = 0;
        for (int i2 = 0; i2 < this.deg.getChildCount(); i2++) {
            View childAt = this.deg.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                TbImageView tbImageView = (TbImageView) childAt;
                tbImageView.aQz();
                tbImageView.setRadius(dimens);
                tbImageView.mD(15);
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.aRT())) {
                        tbImageView.startLoad(tbRichTextImageInfo.aRT(), this.Nj ? 13 : 14, false);
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
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.cNc, this.cNc);
            layoutParams.leftMargin = (this.cNc + this.del) * 4;
            this.deg.addView(imageView, -1, layoutParams);
            imageView.setImageResource(R.drawable.shape_black_0_to_50_vertical);
            this.deh.setVisibility(0);
            this.deh.setText("+" + (this.mImageList.size() - 5));
            this.deh.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    int dimens2 = com.baidu.adp.lib.util.l.getDimens(ThreadGodReplyLayout.this.getContext(), R.dimen.tbds26) + ((ThreadGodReplyLayout.this.cNc - ThreadGodReplyLayout.this.deh.getWidth()) / 2);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ThreadGodReplyLayout.this.deh.getLayoutParams();
                    layoutParams2.setMargins(0, dimens2, dimens2, 0);
                    ThreadGodReplyLayout.this.deh.setLayoutParams(layoutParams2);
                }
            });
            return;
        }
        this.deh.setVisibility(8);
    }

    public void c(PostData postData) {
        this.dek = postData.aRH();
        if (this.dek == null) {
            this.def.setVisibility(8);
            return;
        }
        this.def.setVisibility(0);
        this.def.setTag(this.dek);
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            am.setViewTextColor(this.MK, (int) R.color.cp_cont_b);
            com.baidu.tbadk.core.util.f.a.aEM().kl(R.color.cp_bg_line_g).ag(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10)).aQ(this.mRootView);
            aFO();
            aFN();
            this.dda.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.def.bFO();
        }
    }

    private void aFO() {
        com.baidu.tieba.card.l.a(this.dee, this.Np == null ? null : this.Np.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
    }

    public TextView getGodReplyContent() {
        return this.dee;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(R.id.god_reply_image_layout) != null && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(R.id.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.aRQ());
            }
            String str = "";
            String str2 = "";
            if (this.Np != null) {
                str = this.Np.aAc();
                str2 = this.Np.getTid();
            }
            ImageViewerConfig createConfig = new ImageViewerConfig(getContext()).createConfig(arrayList, intValue, str, "", str2, true, arrayList.get(0), true);
            createConfig.getIntent().putExtra("from", this.mFrom);
            createConfig.getIntent().putExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, true);
            createConfig.setIsShowHost(false);
            createConfig.setThreadData(this.Np);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            if (this.MG != null) {
                this.MG.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.MG = onClickListener;
    }
}
