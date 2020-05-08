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
import com.baidu.card.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public class MutiImgSingleVerticalLayout extends LinearLayout implements m<com.baidu.tbadk.core.data.a> {
    public TextView adB;
    private com.baidu.tbadk.core.data.a ade;
    private z<com.baidu.tbadk.core.data.a> aeC;
    private boolean afo;
    private TbImageView.c agE;
    public PlayVoiceBntNew agJ;
    private boolean agL;
    private boolean agM;
    private LinkedList<MediaData> agN;
    private d agU;
    private boolean agw;
    protected boolean ahd;
    public TbImageView ahf;
    private String mFrom;
    public TextView mTitle;
    private static final int agG = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int agH = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int agI = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int adz = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgSingleVerticalLayout(Context context) {
        this(context, null);
    }

    public MutiImgSingleVerticalLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.agw = true;
        this.ade = null;
        this.agL = false;
        this.agM = false;
        this.ahd = false;
        this.afo = false;
        this.agE = new TbImageView.c() { // from class: com.baidu.card.view.MutiImgSingleVerticalLayout.3
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
                    com.baidu.adp.widget.ImageView.a wP = c.aYk().wP(com.baidu.adp.lib.e.c.kV().genCacheKey(tbImageView.getUrl(), MutiImgSingleVerticalLayout.this.agw ? 13 : 14));
                    if (wP != null) {
                        int width = wP.getWidth();
                        i = wP.getHeight();
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
                            if (MutiImgSingleVerticalLayout.this.ahd && i > i2) {
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
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_single_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.adB = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.agJ = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.agJ.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgSingleVerticalLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<com.baidu.tbadk.core.data.a> subClickListener = MutiImgSingleVerticalLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgSingleVerticalLayout.this.ade);
                }
            }
        });
        this.ahf = (TbImageView) findViewById(R.id.thread_card_img_singal);
        this.ahf.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.ahf.setConrers(15);
        this.ahf.setDrawCorner(true);
        this.ahf.setPlaceHolder(3);
        this.ahf.setLongIconSupport(true);
        this.ahf.setGifIconSupport(true);
        this.agU = new d() { // from class: com.baidu.card.view.MutiImgSingleVerticalLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                z<com.baidu.tbadk.core.data.a> subClickListener = MutiImgSingleVerticalLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgSingleVerticalLayout.this.ade.objType = 2;
                    subClickListener.afJ = false;
                    subClickListener.a(view, MutiImgSingleVerticalLayout.this.ade);
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().dMw) {
                    au.a(view, MutiImgSingleVerticalLayout.this.agw, MutiImgSingleVerticalLayout.this.agN, i, MutiImgSingleVerticalLayout.this.ade.aIu(), MutiImgSingleVerticalLayout.this.mFrom);
                } else if ("index".equals(MutiImgSingleVerticalLayout.this.mFrom)) {
                    au.a(MutiImgSingleVerticalLayout.this.ade, view.getContext(), 2, false);
                } else if ("frs".equals(MutiImgSingleVerticalLayout.this.mFrom)) {
                    au.a(MutiImgSingleVerticalLayout.this.ade, view.getContext(), 3, false);
                } else {
                    au.a(view, MutiImgSingleVerticalLayout.this.agw, MutiImgSingleVerticalLayout.this.agN, i, MutiImgSingleVerticalLayout.this.ade.aIu(), MutiImgSingleVerticalLayout.this.mFrom);
                }
            }
        };
    }

    private void setVoiceData(bj bjVar) {
        ArrayList<VoiceData.VoiceModel> aKQ = bjVar.aKQ();
        if (v.isEmpty(aKQ)) {
            this.agJ.setVisibility(8);
            this.agM = false;
            return;
        }
        this.agJ.setVisibility(0);
        VoiceData.VoiceModel voiceModel = aKQ.get(0);
        this.agJ.setVoiceModel(voiceModel);
        this.agJ.setTag(voiceModel);
        this.agJ.ckM();
        if (voiceModel != null) {
            this.agJ.xC(voiceModel.voice_status.intValue());
        }
        this.agJ.cXw();
        this.agM = true;
    }

    private void setImageData(bj bjVar) {
        ArrayList<MediaData> aKM = bjVar.aKM();
        if (i.aIc().isShowImages() && v.getCount(aKM) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < aKM.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aKM, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.agN = linkedList;
            this.agL = true;
            this.ahf.setVisibility(8);
            if (v.getCount(linkedList) == 1) {
                this.ahf.setVisibility(0);
                a((MediaData) v.getItem(aKM, 0), this.ahf, true, false, true, 0);
                return;
            }
            this.ahf.setVisibility(8);
            this.agL = false;
            return;
        }
        this.ahf.setVisibility(8);
        this.agL = false;
    }

    public void setFromCDN(boolean z) {
        this.agw = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void B(com.baidu.tbadk.core.data.a aVar) {
        this.ade = aVar;
        bj aIu = aVar.aIu();
        au.a(this.mTitle, aIu, this.afo);
        au.a(this.adB, this.mTitle, aIu, adz, this.afo);
        setImageData(aIu);
        setVoiceData(aIu);
        rG();
    }

    private void rG() {
        if (this.adB.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.agL) {
                setMarginsTop(this.agJ, agG);
            } else if (this.agM) {
                setMarginsTop(this.agJ, agI);
            }
        } else if (this.agJ != null && this.agJ.getLayoutParams() != null) {
            if (this.agL) {
                setMarginsTop(this.agJ, agG);
            } else if (this.agM) {
                setMarginsTop(this.agJ, agH);
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

    public z<com.baidu.tbadk.core.data.a> getSubClickListener() {
        return this.aeC;
    }

    public void setSubClickListener(z<com.baidu.tbadk.core.data.a> zVar) {
        this.aeC = zVar;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.agw ? 13 : 14;
        if (!aq.equals(a2, tbImageView.getUrl())) {
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
        tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        tbImageView.setBorderColor(am.getColor(R.color.cp_border_a));
        tbImageView.setBorderSurroundContent(true);
        tbImageView.setPlaceHolder(3);
        tbImageView.setDrawBorder(true);
        tbImageView.setOnDrawListener(this.agE);
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
        this.ahd = z;
    }

    private void a(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.agU != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.agU == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.afo = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        private boolean agW;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.agW = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgSingleVerticalLayout.this.agU != null) {
                MutiImgSingleVerticalLayout.this.agU.b(view, this.currentIndex, this.hasMore && this.agW);
            }
        }
    }
}
