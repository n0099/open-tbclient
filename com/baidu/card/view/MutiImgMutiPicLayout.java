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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
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
    public TextView adV;
    private AbsThreadDataSupport adw;
    private aa<AbsThreadDataSupport> aeY;
    private boolean afL;
    public RelativeLayout ahA;
    public TbImageView ahB;
    public TbImageView ahC;
    public TbImageView ahD;
    private TextView ahF;
    protected boolean ahG;
    private boolean aha;
    private TbImageView.c ahi;
    public PlayVoiceBntNew ahm;
    private boolean aho;
    private boolean ahp;
    private LinkedList<MediaData> ahq;
    private int ahw;
    private d ahx;
    private String mFrom;
    private int mLastScreenWidth;
    public TextView mTitle;
    private static final int ahk = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int adZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int ahl = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int adT = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgMutiPicLayout(Context context) {
        this(context, null);
    }

    public MutiImgMutiPicLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aha = true;
        this.adw = null;
        this.aho = false;
        this.ahp = false;
        this.ahw = 0;
        this.ahG = false;
        this.mLastScreenWidth = 0;
        this.afL = false;
        this.ahi = new TbImageView.c() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.3
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
                    com.baidu.adp.widget.ImageView.a yv = c.bet().yv(com.baidu.adp.lib.e.c.kX().genCacheKey(tbImageView.getUrl(), MutiImgMutiPicLayout.this.aha ? 13 : 14));
                    if (yv != null) {
                        int width = yv.getWidth();
                        i = yv.getHeight();
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
                            if (MutiImgMutiPicLayout.this.ahG && i > i2) {
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
        this.adV = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.ahm = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.ahm.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgMutiPicLayout.this.adw);
                }
            }
        });
        this.ahA = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        this.ahB = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.ahB.setDrawCorner(true);
        this.ahB.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.ahB.setPlaceHolder(2);
        this.ahB.setConrers(15);
        this.ahC = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.ahC.setDrawCorner(false);
        this.ahC.setPlaceHolder(2);
        this.ahC.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.ahC.setConrers(15);
        this.ahD = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.ahD.setDrawCorner(true);
        this.ahD.setPlaceHolder(2);
        this.ahD.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.ahD.setConrers(15);
        this.ahF = (TextView) findViewById(R.id.thread_card_img_more_label);
        this.ahx = new d() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                aa<AbsThreadDataSupport> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgMutiPicLayout.this.adw.objType = 2;
                    subClickListener.agg = Boolean.valueOf(z);
                    subClickListener.a(view, MutiImgMutiPicLayout.this.adw);
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().eaN) {
                    au.a(view, MutiImgMutiPicLayout.this.aha, MutiImgMutiPicLayout.this.ahq, i, MutiImgMutiPicLayout.this.adw.aOi(), MutiImgMutiPicLayout.this.mFrom);
                } else if ("index".equals(MutiImgMutiPicLayout.this.mFrom)) {
                    au.a(MutiImgMutiPicLayout.this.adw, view.getContext(), 2, false);
                } else if ("frs".equals(MutiImgMutiPicLayout.this.mFrom)) {
                    au.a(MutiImgMutiPicLayout.this.adw, view.getContext(), 3, false);
                } else {
                    au.a(view, MutiImgMutiPicLayout.this.aha, MutiImgMutiPicLayout.this.ahq, i, MutiImgMutiPicLayout.this.adw.aOi(), MutiImgMutiPicLayout.this.mFrom);
                }
            }
        };
    }

    private void setVoiceData(bk bkVar) {
        ArrayList<VoiceData.VoiceModel> aQL = bkVar.aQL();
        if (v.isEmpty(aQL)) {
            this.ahm.setVisibility(8);
            this.ahp = false;
            return;
        }
        this.ahm.setVisibility(0);
        VoiceData.VoiceModel voiceModel = aQL.get(0);
        this.ahm.setVoiceModel(voiceModel);
        this.ahm.setTag(voiceModel);
        this.ahm.crm();
        if (voiceModel != null) {
            this.ahm.yi(voiceModel.voice_status.intValue());
        }
        this.ahm.deL();
        this.ahp = true;
    }

    private void setImageData(bk bkVar) {
        boolean z;
        ArrayList<MediaData> aQH = bkVar.aQH();
        if (k.aNQ().isShowImages() && v.getCount(aQH) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < aQH.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aQH, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.ahq = linkedList;
            this.aho = true;
            if (linkedList.size() > 3) {
                this.ahF.setText(TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(linkedList.size() - 3)}));
                this.ahF.setVisibility(0);
                z = true;
            } else {
                this.ahF.setVisibility(8);
                z = false;
            }
            this.ahA.setVisibility(8);
            if (v.getCount(linkedList) == 2) {
                this.ahA.setVisibility(0);
                a((MediaData) v.getItem(aQH, 0), this.ahB, z, false, 0);
                this.ahC.setVisibility(8);
                a((MediaData) v.getItem(aQH, 1), this.ahD, z, false, 1);
                return;
            } else if (v.getCount(linkedList) >= 3) {
                this.ahA.setVisibility(0);
                this.ahC.setVisibility(0);
                a((MediaData) v.getItem(aQH, 0), this.ahB, z, false, 0);
                a((MediaData) v.getItem(aQH, 1), this.ahC, z, false, 1);
                a((MediaData) v.getItem(aQH, 2), this.ahD, z, true, 2);
                return;
            } else {
                this.ahA.setVisibility(8);
                this.aho = false;
                return;
            }
        }
        this.ahA.setVisibility(8);
        this.aho = false;
    }

    public void setFromCDN(boolean z) {
        this.aha = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adw = absThreadDataSupport;
        bk aOi = absThreadDataSupport.aOi();
        au.a(this.mTitle, aOi, this.afL);
        au.a(this.adV, this.mTitle, aOi, adT, this.afL);
        setImageData(aOi);
        setVoiceData(aOi);
        rP();
    }

    private void rP() {
        if (this.adV.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.aho) {
                setMarginsTop(this.ahm, ahk);
            } else if (this.ahp) {
                setMarginsTop(this.ahm, ahl);
            }
        } else if (this.ahm != null && this.ahm.getLayoutParams() != null) {
            if (this.aho) {
                setMarginsTop(this.ahm, ahk);
            } else if (this.ahp) {
                setMarginsTop(this.ahm, adZ);
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
        return this.aeY;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.aeY = aaVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bo = bo(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ahB.getLayoutParams();
        layoutParams.width = bo;
        layoutParams.height = bo;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ahC.getLayoutParams();
        layoutParams2.width = bo;
        layoutParams2.height = bo;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.ahD.getLayoutParams();
        layoutParams3.width = bo;
        layoutParams3.height = bo;
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.ahF.getLayoutParams();
        layoutParams4.width = bo;
        layoutParams4.height = bo;
        if (this.ahA.getVisibility() != 8) {
            this.ahB.setLayoutParams(layoutParams);
            this.ahC.setLayoutParams(layoutParams2);
            this.ahD.setLayoutParams(layoutParams3);
            this.ahF.setLayoutParams(layoutParams4);
        }
    }

    private int bo(int i) {
        if (this.ahw > 0) {
            int equipmentWidth = l.getEquipmentWidth(getContext());
            if (equipmentWidth == this.mLastScreenWidth) {
                return this.ahw;
            }
            this.mLastScreenWidth = equipmentWidth;
        }
        this.ahw = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.ahw;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, int i) {
        String a2 = a(mediaData);
        int i2 = this.aha ? 13 : 14;
        if (!aq.equals(a2, tbImageView.getUrl())) {
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
        tbImageView.setBorderColor(am.getColor(R.color.cp_border_a));
        tbImageView.setBorderSurroundContent(true);
        tbImageView.setDrawBorder(true);
        tbImageView.setOnDrawListener(this.ahi);
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
        this.ahG = z;
    }

    private void a(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.ahx != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.ahx == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.afL = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        private boolean ahz;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.ahz = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgMutiPicLayout.this.ahx != null) {
                MutiImgMutiPicLayout.this.ahx.b(view, this.currentIndex, this.hasMore && this.ahz);
            }
        }
    }
}
