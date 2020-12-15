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
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.a.b;
import com.baidu.card.p;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes21.dex */
public class MutiImgSingleVerticalLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
    private static final int ahn;
    private com.baidu.tbadk.core.data.a agJ;
    public TextView ahp;
    private ab<com.baidu.tbadk.core.data.a> aix;
    private boolean ajm;
    public PlayVoiceBntNew alB;
    private boolean alD;
    private boolean alE;
    private LinkedList<MediaData> alF;
    public TbImageView alN;
    private d alP;
    protected boolean alQ;
    private boolean alo;
    private TbImageView.b alw;
    private String mFrom;
    public TextView mTitle;

    public void setFrom(String str) {
        this.mFrom = str;
    }

    static {
        ahn = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.tbadk.a.d.bkA() ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007) * 2 : (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    public MutiImgSingleVerticalLayout(Context context) {
        this(context, null);
    }

    public MutiImgSingleVerticalLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alo = true;
        this.agJ = null;
        this.alD = false;
        this.alE = false;
        this.alQ = false;
        this.ajm = false;
        this.alw = new TbImageView.b() { // from class: com.baidu.card.view.MutiImgSingleVerticalLayout.3
            @Override // com.baidu.tbadk.widget.TbImageView.b
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
                    com.baidu.adp.widget.ImageView.a Ei = c.bDV().Ei(com.baidu.adp.lib.e.c.mS().genCacheKey(tbImageView.getUrl(), MutiImgSingleVerticalLayout.this.alo ? 13 : 14));
                    if (Ei != null) {
                        int width = Ei.getWidth();
                        i = Ei.getHeight();
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
                            if (MutiImgSingleVerticalLayout.this.alQ && i > i2) {
                                imageMatrix.postTranslate(f3, 0.0f);
                            } else {
                                imageMatrix.postTranslate(f3, f);
                            }
                        }
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        };
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_single_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ahp = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.alB = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.alB.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgSingleVerticalLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgSingleVerticalLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgSingleVerticalLayout.this.agJ);
                }
            }
        });
        this.alN = (TbImageView) findViewById(R.id.thread_card_img_singal);
        this.alN.setRadiusById(R.string.J_X05);
        this.alN.setConrers(15);
        this.alN.setDrawCorner(true);
        this.alN.setPlaceHolder(3);
        this.alN.setLongIconSupport(true);
        this.alN.setGifIconSupport(true);
        this.alP = new d() { // from class: com.baidu.card.view.MutiImgSingleVerticalLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgSingleVerticalLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgSingleVerticalLayout.this.agJ.objType = 2;
                    subClickListener.ajN = false;
                    subClickListener.a(view, MutiImgSingleVerticalLayout.this.agJ);
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().fjd) {
                    az.a(view, MutiImgSingleVerticalLayout.this.alo, MutiImgSingleVerticalLayout.this.alF, i, MutiImgSingleVerticalLayout.this.agJ.bmn(), MutiImgSingleVerticalLayout.this.mFrom);
                } else if ("index".equals(MutiImgSingleVerticalLayout.this.mFrom)) {
                    az.a(MutiImgSingleVerticalLayout.this.agJ, view.getContext(), 2, false);
                } else if ("frs".equals(MutiImgSingleVerticalLayout.this.mFrom)) {
                    az.a(MutiImgSingleVerticalLayout.this.agJ, view.getContext(), 3, false);
                } else {
                    az.a(view, MutiImgSingleVerticalLayout.this.alo, MutiImgSingleVerticalLayout.this.alF, i, MutiImgSingleVerticalLayout.this.agJ.bmn(), MutiImgSingleVerticalLayout.this.mFrom);
                }
            }
        };
    }

    private void setVoiceData(by byVar) {
        ArrayList<VoiceData.VoiceModel> bpc = byVar.bpc();
        if (y.isEmpty(bpc)) {
            this.alB.setVisibility(8);
            this.alE = false;
            return;
        }
        this.alB.setVisibility(0);
        VoiceData.VoiceModel voiceModel = bpc.get(0);
        this.alB.setVoiceModel(voiceModel);
        this.alB.setTag(voiceModel);
        this.alB.bvs();
        if (voiceModel != null) {
            this.alB.EM(voiceModel.voice_status.intValue());
        }
        this.alB.ccA();
        this.alE = true;
    }

    private void setImageData(by byVar) {
        ArrayList<MediaData> boY = byVar.boY();
        if (k.blV().isShowImages() && y.getCount(boY) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < boY.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(boY, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.alF = linkedList;
            this.alD = true;
            this.alN.setVisibility(8);
            if (y.getCount(linkedList) == 1) {
                this.alN.setVisibility(0);
                a((MediaData) y.getItem(boY, 0), this.alN, true, false, true, 0);
                return;
            }
            this.alN.setVisibility(8);
            this.alD = false;
            return;
        }
        this.alN.setVisibility(8);
        this.alD = false;
    }

    public void setFromCDN(boolean z) {
        this.alo = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        boolean z = true;
        this.agJ = aVar;
        by bmn = aVar.bmn();
        az.a(this.mTitle, bmn, this.ajm);
        az.a(this.ahp, this.mTitle, bmn, ahn, this.ajm);
        boolean z2 = this.mTitle == null || this.mTitle.getVisibility() != 0;
        boolean z3 = this.ahp == null || this.ahp.getVisibility() != 0;
        TbImageView tbImageView = this.alN;
        if (!z2 || !z3) {
            z = false;
        }
        az.a(tbImageView, z, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        setImageData(bmn);
        setVoiceData(bmn);
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

    public ab<com.baidu.tbadk.core.data.a> getSubClickListener() {
        return this.aix;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.aix = abVar;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.alo ? 13 : 14;
        if (!au.equals(a2, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        setCanCenterStart(true);
        boolean isLongPic = mediaData.isLongPic();
        boolean isSmartCrop = mediaData.isSmartCrop();
        tbImageView.setScaleType(ImageView.ScaleType.MATRIX);
        tbImageView.setIsLongPic(isLongPic);
        tbImageView.setIsSmartCrop(isSmartCrop);
        tbImageView.setSmartCropCenterPointWidthRatio((float) mediaData.getSmartCropCenterPointWidthRatio());
        tbImageView.setSmartCropCenterPointHeightRatio((float) mediaData.getSmartCropCenterPointHeightRatio());
        tbImageView.setForegroundColor(0);
        tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.L_X01));
        tbImageView.setBorderColor(ap.getColor(R.color.CAM_X0401));
        tbImageView.setBorderSurroundContent(true);
        tbImageView.setPlaceHolder(3);
        tbImageView.setDrawBorder(true);
        tbImageView.setOnDrawListener(this.alw);
        tbImageView.startLoad(a2, i2, false);
        a(tbImageView, i, z2, z3);
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
        this.alQ = z;
    }

    private void a(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.alP != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.alP == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.ajm = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a implements View.OnClickListener {
        private boolean alS;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.alS = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgSingleVerticalLayout.this.alP != null) {
                MutiImgSingleVerticalLayout.this.alP.b(view, this.currentIndex, this.hasMore && this.alS);
            }
        }
    }
}
