package com.baidu.card.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.a.b;
import com.baidu.card.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public class MutiImgMutiPicLayout extends LinearLayout implements n<AbsThreadDataSupport> {
    public TextView aeA;
    private AbsThreadDataSupport aea;
    private aa<AbsThreadDataSupport> afH;
    private boolean agw;
    private LinkedList<MediaData> aiA;
    private int aiG;
    private d aiH;
    public RelativeLayout aiK;
    public TbImageView aiL;
    public TbImageView aiM;
    public TbImageView aiN;
    private TextView aiP;
    protected boolean aiQ;
    private boolean aik;
    private TbImageView.c ais;
    public PlayVoiceBntNew aiw;
    private boolean aiy;
    private boolean aiz;
    private String mFrom;
    private int mLastScreenWidth;
    public TextView mTitle;
    private static final int aiu = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int aeF = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int aiv = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int aey = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgMutiPicLayout(Context context) {
        this(context, null);
    }

    public MutiImgMutiPicLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aik = true;
        this.aea = null;
        this.aiy = false;
        this.aiz = false;
        this.aiG = 0;
        this.aiQ = false;
        this.mLastScreenWidth = 0;
        this.agw = false;
        this.ais = new TbImageView.c() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.3
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                int i2;
                float f;
                float f2;
                float f3;
                float f4;
                float f5;
                float f6;
                float f7 = 0.0f;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a yO = c.bgz().yO(com.baidu.adp.lib.e.c.ln().genCacheKey(tbImageView.getUrl(), MutiImgMutiPicLayout.this.aik ? 13 : 14));
                    if (yO != null) {
                        int width = yO.getWidth();
                        i = yO.getHeight();
                        i2 = width;
                    } else {
                        i = 0;
                        i2 = 0;
                    }
                    if (i2 != 0 && i != 0) {
                        int width2 = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                        int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                        Matrix imageMatrix = tbImageView.getImageMatrix();
                        if (tbImageView.isSmartCrop() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            float smartCropCenterPointWidthRatio = tbImageView.getSmartCropCenterPointWidthRatio();
                            float smartCropCenterPointHeightRatio = tbImageView.getSmartCropCenterPointHeightRatio();
                            if (i2 * height > width2 * i) {
                                f5 = height / i;
                                float f8 = i2 * smartCropCenterPointWidthRatio * f5;
                                if (f8 < width2 * 0.5f) {
                                    f6 = 0.0f;
                                } else if ((i2 * f5) - f8 < width2 * 0.5f) {
                                    f6 = width2 - (i2 * f5);
                                } else {
                                    f6 = (width2 * 0.5f) - f8;
                                }
                            } else {
                                f5 = width2 / i2;
                                float f9 = i * smartCropCenterPointHeightRatio * f5;
                                if (f9 < height * 0.5f) {
                                    f6 = 0.0f;
                                } else if ((i * f5) - f9 < height * 0.5f) {
                                    f6 = 0.0f;
                                    f7 = height - (i * f5);
                                } else {
                                    float f10 = (height * 0.5f) - f9;
                                    f6 = 0.0f;
                                    f7 = f10;
                                }
                            }
                            imageMatrix.setScale(f5, f5);
                            imageMatrix.postTranslate(f6, f7);
                        } else if (tbImageView.isLongPic() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i2 * height > width2 * i) {
                                f4 = height / i;
                            } else {
                                f4 = width2 / i2;
                            }
                            imageMatrix.setScale(f4, f4);
                            imageMatrix.postTranslate(0.0f, 0.0f);
                        } else if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i2 * height > width2 * i) {
                                float f11 = height / i;
                                f2 = f11;
                                f3 = (width2 - (i2 * f11)) * 0.5f;
                                f = 0.0f;
                            } else {
                                float f12 = width2 / i2;
                                f = (height - (i * f12)) * 0.5f;
                                f2 = f12;
                                f3 = 0.0f;
                            }
                            imageMatrix.setScale(f2, f2);
                            if (MutiImgMutiPicLayout.this.aiQ && i > i2) {
                                imageMatrix.postTranslate(f3, 0.0f);
                            } else {
                                imageMatrix.postTranslate(f3, f);
                            }
                        }
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        };
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_more_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.aeA = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.aiw = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.aiw.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgMutiPicLayout.this.aea);
                }
            }
        });
        this.aiK = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        this.aiL = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.aiL.setDrawCorner(true);
        this.aiL.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.aiL.setPlaceHolder(2);
        this.aiL.setConrers(15);
        this.aiM = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.aiM.setDrawCorner(false);
        this.aiM.setPlaceHolder(2);
        this.aiM.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.aiM.setConrers(15);
        this.aiN = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.aiN.setDrawCorner(true);
        this.aiN.setPlaceHolder(2);
        this.aiN.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.aiN.setConrers(15);
        this.aiP = (TextView) findViewById(R.id.thread_card_img_more_label);
        this.aiH = new d() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                aa<AbsThreadDataSupport> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgMutiPicLayout.this.aea.objType = 2;
                    subClickListener.agT = Boolean.valueOf(z);
                    subClickListener.a(view, MutiImgMutiPicLayout.this.aea);
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().ejx) {
                    aw.a(view, MutiImgMutiPicLayout.this.aik, MutiImgMutiPicLayout.this.aiA, i, MutiImgMutiPicLayout.this.aea.aPS(), MutiImgMutiPicLayout.this.mFrom);
                } else if ("index".equals(MutiImgMutiPicLayout.this.mFrom)) {
                    aw.a(MutiImgMutiPicLayout.this.aea, view.getContext(), 2, false);
                } else if ("frs".equals(MutiImgMutiPicLayout.this.mFrom)) {
                    aw.a(MutiImgMutiPicLayout.this.aea, view.getContext(), 3, false);
                } else {
                    aw.a(view, MutiImgMutiPicLayout.this.aik, MutiImgMutiPicLayout.this.aiA, i, MutiImgMutiPicLayout.this.aea.aPS(), MutiImgMutiPicLayout.this.mFrom);
                }
            }
        };
    }

    private void setVoiceData(bu buVar) {
        ArrayList<VoiceData.VoiceModel> aSC = buVar.aSC();
        if (w.isEmpty(aSC)) {
            this.aiw.setVisibility(8);
            this.aiz = false;
            return;
        }
        this.aiw.setVisibility(0);
        VoiceData.VoiceModel voiceModel = aSC.get(0);
        this.aiw.setVoiceModel(voiceModel);
        this.aiw.setTag(voiceModel);
        this.aiw.aYi();
        if (voiceModel != null) {
            this.aiw.yU(voiceModel.voice_status.intValue());
        }
        this.aiw.bCo();
        this.aiz = true;
    }

    private void setImageData(bu buVar) {
        boolean z;
        ArrayList<MediaData> aSy = buVar.aSy();
        if (k.aPA().isShowImages() && w.getCount(aSy) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < aSy.size(); i++) {
                MediaData mediaData = (MediaData) w.getItem(aSy, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.aiA = linkedList;
            this.aiy = true;
            if (linkedList.size() > 3) {
                this.aiP.setText(TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(linkedList.size() - 3)}));
                this.aiP.setVisibility(0);
                z = true;
            } else {
                this.aiP.setVisibility(8);
                z = false;
            }
            this.aiK.setVisibility(8);
            if (w.getCount(linkedList) == 2) {
                this.aiK.setVisibility(0);
                a((MediaData) w.getItem(aSy, 0), this.aiL, z, false, 0);
                this.aiM.setVisibility(8);
                a((MediaData) w.getItem(aSy, 1), this.aiN, z, false, 1);
                return;
            } else if (w.getCount(linkedList) >= 3) {
                this.aiK.setVisibility(0);
                this.aiM.setVisibility(0);
                a((MediaData) w.getItem(aSy, 0), this.aiL, z, false, 0);
                a((MediaData) w.getItem(aSy, 1), this.aiM, z, false, 1);
                a((MediaData) w.getItem(aSy, 2), this.aiN, z, true, 2);
                return;
            } else {
                this.aiK.setVisibility(8);
                this.aiy = false;
                return;
            }
        }
        this.aiK.setVisibility(8);
        this.aiy = false;
    }

    public void setFromCDN(boolean z) {
        this.aik = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.aea = absThreadDataSupport;
        bu aPS = absThreadDataSupport.aPS();
        aw.a(this.mTitle, aPS, this.agw);
        aw.a(this.aeA, this.mTitle, aPS, aey, this.agw);
        setImageData(aPS);
        setVoiceData(aPS);
        sh();
    }

    private void sh() {
        if (this.aeA.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.aiy) {
                setMarginsTop(this.aiw, aiu);
            } else if (this.aiz) {
                setMarginsTop(this.aiw, aiv);
            }
        } else if (this.aiw != null && this.aiw.getLayoutParams() != null) {
            if (this.aiy) {
                setMarginsTop(this.aiw, aiu);
            } else if (this.aiz) {
                setMarginsTop(this.aiw, aeF);
            }
        }
    }

    public void setMarginsTop(View view, int i) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public aa<AbsThreadDataSupport> getSubClickListener() {
        return this.afH;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.afH = aaVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bt = bt(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aiL.getLayoutParams();
        layoutParams.width = bt;
        layoutParams.height = bt;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aiM.getLayoutParams();
        layoutParams2.width = bt;
        layoutParams2.height = bt;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.aiN.getLayoutParams();
        layoutParams3.width = bt;
        layoutParams3.height = bt;
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.aiP.getLayoutParams();
        layoutParams4.width = bt;
        layoutParams4.height = bt;
        if (this.aiK.getVisibility() != 8) {
            this.aiL.setLayoutParams(layoutParams);
            this.aiM.setLayoutParams(layoutParams2);
            this.aiN.setLayoutParams(layoutParams3);
            this.aiP.setLayoutParams(layoutParams4);
        }
    }

    private int bt(int i) {
        if (this.aiG > 0) {
            int equipmentWidth = l.getEquipmentWidth(getContext());
            if (equipmentWidth == this.mLastScreenWidth) {
                return this.aiG;
            }
            this.mLastScreenWidth = equipmentWidth;
        }
        this.aiG = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.aiG;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, int i) {
        String a2 = a(mediaData);
        int i2 = this.aik ? 13 : 14;
        if (!ar.equals(a2, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        setCanCenterStart(false);
        boolean isLongPic = mediaData.isLongPic();
        boolean isSmartCrop = mediaData.isSmartCrop();
        tbImageView.setScaleType(ImageView.ScaleType.MATRIX);
        tbImageView.setIsLongPic(isLongPic);
        tbImageView.setIsSmartCrop(isSmartCrop);
        tbImageView.setSmartCropCenterPointWidthRatio((float) mediaData.getSmartCropCenterPointWidthRatio());
        tbImageView.setSmartCropCenterPointHeightRatio((float) mediaData.getSmartCropCenterPointHeightRatio());
        tbImageView.setForegroundColor(0);
        tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        tbImageView.setBorderColor(an.getColor(R.color.cp_border_a));
        tbImageView.setBorderSurroundContent(true);
        tbImageView.setDrawBorder(true);
        tbImageView.setOnDrawListener(this.ais);
        tbImageView.setPlaceHolder(2);
        if (z2 && z) {
            tbImageView.setLongIconSupport(false);
            tbImageView.setGifIconSupport(false);
        } else {
            tbImageView.setLongIconSupport(true);
            tbImageView.setGifIconSupport(true);
        }
        tbImageView.startLoad(a2, i2, false);
        a(tbImageView, i, z, z2);
    }

    private String a(MediaData mediaData) {
        if (mediaData == null) {
            return "";
        }
        String picUrl = mediaData.getPicUrl();
        if (TextUtils.isEmpty(picUrl)) {
            picUrl = mediaData.getSmallUrl();
        }
        if (TextUtils.isEmpty(picUrl)) {
            picUrl = mediaData.getThumbnails_url();
        }
        if (TextUtils.isEmpty(picUrl)) {
            return mediaData.getSrc_pic();
        }
        return picUrl;
    }

    public void setCanCenterStart(boolean z) {
        this.aiQ = z;
    }

    private void a(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.aiH != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.aiH == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.agw = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        private boolean aiJ;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.aiJ = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgMutiPicLayout.this.aiH != null) {
                MutiImgMutiPicLayout.this.aiH.b(view, this.currentIndex, this.hasMore && this.aiJ);
            }
        }
    }
}
