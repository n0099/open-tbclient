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
public class MutiImgMutiPicLayout extends LinearLayout implements m<com.baidu.tbadk.core.data.a> {
    public TextView adB;
    private com.baidu.tbadk.core.data.a ade;
    private z<com.baidu.tbadk.core.data.a> aeC;
    private boolean afo;
    private TbImageView.c agE;
    public PlayVoiceBntNew agJ;
    private boolean agL;
    private boolean agM;
    private LinkedList<MediaData> agN;
    private int agT;
    private d agU;
    public RelativeLayout agX;
    public TbImageView agY;
    public TbImageView agZ;
    private boolean agw;
    public TbImageView aha;
    private TextView ahc;
    protected boolean ahd;
    private String mFrom;
    private int mLastScreenWidth;
    public TextView mTitle;
    private static final int agG = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int agH = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int agI = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int adz = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgMutiPicLayout(Context context) {
        this(context, null);
    }

    public MutiImgMutiPicLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.agw = true;
        this.ade = null;
        this.agL = false;
        this.agM = false;
        this.agT = 0;
        this.ahd = false;
        this.mLastScreenWidth = 0;
        this.afo = false;
        this.agE = new TbImageView.c() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.3
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
                    com.baidu.adp.widget.ImageView.a wP = c.aYk().wP(com.baidu.adp.lib.e.c.kV().genCacheKey(tbImageView.getUrl(), MutiImgMutiPicLayout.this.agw ? 13 : 14));
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
                            if (MutiImgMutiPicLayout.this.ahd && i > i2) {
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
        this.adB = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.agJ = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.agJ.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgMutiPicLayout.this.ade);
                }
            }
        });
        this.agX = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        this.agY = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.agY.setDrawCorner(true);
        this.agY.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.agY.setPlaceHolder(2);
        this.agY.setConrers(15);
        this.agZ = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.agZ.setDrawCorner(false);
        this.agZ.setPlaceHolder(2);
        this.agZ.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.agZ.setConrers(15);
        this.aha = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.aha.setDrawCorner(true);
        this.aha.setPlaceHolder(2);
        this.aha.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.aha.setConrers(15);
        this.ahc = (TextView) findViewById(R.id.thread_card_img_more_label);
        this.agU = new d() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                z<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgMutiPicLayout.this.ade.objType = 2;
                    subClickListener.afJ = Boolean.valueOf(z);
                    subClickListener.a(view, MutiImgMutiPicLayout.this.ade);
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().dMw) {
                    au.a(view, MutiImgMutiPicLayout.this.agw, MutiImgMutiPicLayout.this.agN, i, MutiImgMutiPicLayout.this.ade.aIu(), MutiImgMutiPicLayout.this.mFrom);
                } else if ("index".equals(MutiImgMutiPicLayout.this.mFrom)) {
                    au.a(MutiImgMutiPicLayout.this.ade, view.getContext(), 2, false);
                } else if ("frs".equals(MutiImgMutiPicLayout.this.mFrom)) {
                    au.a(MutiImgMutiPicLayout.this.ade, view.getContext(), 3, false);
                } else {
                    au.a(view, MutiImgMutiPicLayout.this.agw, MutiImgMutiPicLayout.this.agN, i, MutiImgMutiPicLayout.this.ade.aIu(), MutiImgMutiPicLayout.this.mFrom);
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
        this.agJ.ckN();
        if (voiceModel != null) {
            this.agJ.xC(voiceModel.voice_status.intValue());
        }
        this.agJ.cXx();
        this.agM = true;
    }

    private void setImageData(bj bjVar) {
        boolean z;
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
            if (linkedList.size() > 3) {
                this.ahc.setText(TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(linkedList.size() - 3)}));
                this.ahc.setVisibility(0);
                z = true;
            } else {
                this.ahc.setVisibility(8);
                z = false;
            }
            this.agX.setVisibility(8);
            if (v.getCount(linkedList) == 2) {
                this.agX.setVisibility(0);
                a((MediaData) v.getItem(aKM, 0), this.agY, z, false, 0);
                this.agZ.setVisibility(8);
                a((MediaData) v.getItem(aKM, 1), this.aha, z, false, 1);
                return;
            } else if (v.getCount(linkedList) >= 3) {
                this.agX.setVisibility(0);
                this.agZ.setVisibility(0);
                a((MediaData) v.getItem(aKM, 0), this.agY, z, false, 0);
                a((MediaData) v.getItem(aKM, 1), this.agZ, z, false, 1);
                a((MediaData) v.getItem(aKM, 2), this.aha, z, true, 2);
                return;
            } else {
                this.agX.setVisibility(8);
                this.agL = false;
                return;
            }
        }
        this.agX.setVisibility(8);
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

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bn = bn(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.agY.getLayoutParams();
        layoutParams.width = bn;
        layoutParams.height = bn;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.agZ.getLayoutParams();
        layoutParams2.width = bn;
        layoutParams2.height = bn;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.aha.getLayoutParams();
        layoutParams3.width = bn;
        layoutParams3.height = bn;
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.ahc.getLayoutParams();
        layoutParams4.width = bn;
        layoutParams4.height = bn;
        if (this.agX.getVisibility() != 8) {
            this.agY.setLayoutParams(layoutParams);
            this.agZ.setLayoutParams(layoutParams2);
            this.aha.setLayoutParams(layoutParams3);
            this.ahc.setLayoutParams(layoutParams4);
        }
    }

    private int bn(int i) {
        if (this.agT > 0) {
            int equipmentWidth = l.getEquipmentWidth(getContext());
            if (equipmentWidth == this.mLastScreenWidth) {
                return this.agT;
            }
            this.mLastScreenWidth = equipmentWidth;
        }
        this.agT = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.agT;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, int i) {
        String a2 = a(mediaData);
        int i2 = this.agw ? 13 : 14;
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
        tbImageView.setOnDrawListener(this.agE);
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
            if (MutiImgMutiPicLayout.this.agU != null) {
                MutiImgMutiPicLayout.this.agU.b(view, this.currentIndex, this.hasMore && this.agW);
            }
        }
    }
}
