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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes15.dex */
public class MutiImgMutiPicLayout extends LinearLayout implements n<AbsThreadDataSupport> {
    private AbsThreadDataSupport adQ;
    public TextView aeq;
    private aa<AbsThreadDataSupport> afy;
    private boolean agn;
    public RelativeLayout aiC;
    public TbImageView aiD;
    public TbImageView aiE;
    public TbImageView aiF;
    private TextView aiH;
    protected boolean aiI;
    private boolean aib;
    private TbImageView.c aik;
    public PlayVoiceBntNew aio;
    private boolean aiq;
    private boolean air;
    private LinkedList<MediaData> ais;
    private int aiy;
    private d aiz;
    private String mFrom;
    private int mLastScreenWidth;
    public TextView mTitle;
    private static final int aim = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int aev = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int ain = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int aeo = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgMutiPicLayout(Context context) {
        this(context, null);
    }

    public MutiImgMutiPicLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aib = true;
        this.adQ = null;
        this.aiq = false;
        this.air = false;
        this.aiy = 0;
        this.aiI = false;
        this.mLastScreenWidth = 0;
        this.agn = false;
        this.aik = new TbImageView.c() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.3
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
                    com.baidu.adp.widget.ImageView.a zV = c.bkk().zV(com.baidu.adp.lib.e.c.ln().genCacheKey(tbImageView.getUrl(), MutiImgMutiPicLayout.this.aib ? 13 : 14));
                    if (zV != null) {
                        int width = zV.getWidth();
                        i = zV.getHeight();
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
                            if (MutiImgMutiPicLayout.this.aiI && i > i2) {
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
        this.aeq = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.aio = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.aio.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgMutiPicLayout.this.adQ);
                }
            }
        });
        this.aiC = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        com.baidu.tbadk.a.b.a.e(this.aiC, R.dimen.tbds26, R.dimen.tbds14);
        com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
        com.baidu.tbadk.a.b.a.a(this.aeq, R.dimen.tbds7, R.dimen.tbds10);
        this.aiD = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.aiD.setDrawCorner(true);
        this.aiD.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.aiD.setPlaceHolder(2);
        this.aiD.setConrers(15);
        this.aiE = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.aiE.setDrawCorner(false);
        this.aiE.setPlaceHolder(2);
        this.aiE.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.aiE.setConrers(15);
        this.aiF = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.aiF.setDrawCorner(true);
        this.aiF.setPlaceHolder(2);
        this.aiF.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.aiF.setConrers(15);
        this.aiH = (TextView) findViewById(R.id.thread_card_img_more_label);
        this.aiz = new d() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                aa<AbsThreadDataSupport> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgMutiPicLayout.this.adQ.objType = 2;
                    subClickListener.agK = Boolean.valueOf(z);
                    subClickListener.a(view, MutiImgMutiPicLayout.this.adQ);
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().epJ) {
                    ax.a(view, MutiImgMutiPicLayout.this.aib, MutiImgMutiPicLayout.this.ais, i, MutiImgMutiPicLayout.this.adQ.aTN(), MutiImgMutiPicLayout.this.mFrom);
                } else if ("index".equals(MutiImgMutiPicLayout.this.mFrom)) {
                    ax.a(MutiImgMutiPicLayout.this.adQ, view.getContext(), 2, false);
                } else if ("frs".equals(MutiImgMutiPicLayout.this.mFrom)) {
                    ax.a(MutiImgMutiPicLayout.this.adQ, view.getContext(), 3, false);
                } else {
                    ax.a(view, MutiImgMutiPicLayout.this.aib, MutiImgMutiPicLayout.this.ais, i, MutiImgMutiPicLayout.this.adQ.aTN(), MutiImgMutiPicLayout.this.mFrom);
                }
            }
        };
    }

    private void setVoiceData(bv bvVar) {
        ArrayList<VoiceData.VoiceModel> aWy = bvVar.aWy();
        if (x.isEmpty(aWy)) {
            this.aio.setVisibility(8);
            this.air = false;
            return;
        }
        this.aio.setVisibility(0);
        VoiceData.VoiceModel voiceModel = aWy.get(0);
        this.aio.setVoiceModel(voiceModel);
        this.aio.setTag(voiceModel);
        this.aio.changeSkin();
        if (voiceModel != null) {
            this.aio.zt(voiceModel.voice_status.intValue());
        }
        this.aio.bFz();
        this.air = true;
    }

    private void setImageData(bv bvVar) {
        boolean z;
        ArrayList<MediaData> aWu = bvVar.aWu();
        if (k.aTv().isShowImages() && x.getCount(aWu) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < aWu.size(); i++) {
                MediaData mediaData = (MediaData) x.getItem(aWu, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.ais = linkedList;
            this.aiq = true;
            com.baidu.tbadk.a.b.a.h(this.aiH, R.drawable.thread_card_more_number_bg);
            if (linkedList.size() > 3) {
                this.aiH.setText(TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(linkedList.size() - 3)}));
                this.aiH.setVisibility(0);
                z = true;
            } else {
                this.aiH.setVisibility(8);
                z = false;
            }
            this.aiC.setVisibility(8);
            if (x.getCount(linkedList) == 2) {
                this.aiC.setVisibility(0);
                a((MediaData) x.getItem(aWu, 0), this.aiD, z, false, 0);
                this.aiE.setVisibility(8);
                a((MediaData) x.getItem(aWu, 1), this.aiF, z, false, 1);
                return;
            } else if (x.getCount(linkedList) >= 3) {
                this.aiC.setVisibility(0);
                this.aiE.setVisibility(0);
                a((MediaData) x.getItem(aWu, 0), this.aiD, z, false, 0);
                a((MediaData) x.getItem(aWu, 1), this.aiE, z, false, 1);
                a((MediaData) x.getItem(aWu, 2), this.aiF, z, true, 2);
                return;
            } else {
                this.aiC.setVisibility(8);
                this.aiq = false;
                return;
            }
        }
        this.aiC.setVisibility(8);
        this.aiq = false;
    }

    public void setFromCDN(boolean z) {
        this.aib = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adQ = absThreadDataSupport;
        bv aTN = absThreadDataSupport.aTN();
        ax.a(this.mTitle, aTN, this.agn);
        ax.a(this.aeq, this.mTitle, aTN, aeo, this.agn);
        setImageData(aTN);
        setVoiceData(aTN);
        sj();
    }

    private void sj() {
        if (this.aeq.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.aiq) {
                setMarginsTop(this.aio, aim);
            } else if (this.air) {
                setMarginsTop(this.aio, ain);
            }
        } else if (this.aio != null && this.aio.getLayoutParams() != null) {
            if (this.aiq) {
                setMarginsTop(this.aio, aim);
            } else if (this.air) {
                setMarginsTop(this.aio, aev);
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
        return this.afy;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.afy = aaVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bv = bv(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aiD.getLayoutParams();
        layoutParams.width = bv;
        layoutParams.height = bv;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aiE.getLayoutParams();
        layoutParams2.width = bv;
        layoutParams2.height = bv;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.aiF.getLayoutParams();
        layoutParams3.width = bv;
        layoutParams3.height = bv;
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.aiH.getLayoutParams();
        layoutParams4.width = bv;
        layoutParams4.height = bv;
        if (this.aiC.getVisibility() != 8) {
            this.aiD.setLayoutParams(layoutParams);
            this.aiE.setLayoutParams(layoutParams2);
            this.aiF.setLayoutParams(layoutParams3);
            this.aiH.setLayoutParams(layoutParams4);
        }
    }

    private int bv(int i) {
        if (this.aiy > 0) {
            int equipmentWidth = l.getEquipmentWidth(getContext());
            if (equipmentWidth == this.mLastScreenWidth) {
                return this.aiy;
            }
            this.mLastScreenWidth = equipmentWidth;
        }
        this.aiy = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.aiy;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, int i) {
        String a2 = a(mediaData);
        int i2 = this.aib ? 13 : 14;
        if (!as.equals(a2, tbImageView.getUrl())) {
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
        tbImageView.setBorderColor(ao.getColor(R.color.cp_border_a));
        tbImageView.setBorderSurroundContent(true);
        tbImageView.setDrawBorder(true);
        tbImageView.setOnDrawListener(this.aik);
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
        this.aiI = z;
    }

    private void a(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.aiz != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.aiz == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.agn = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a implements View.OnClickListener {
        private boolean aiB;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.aiB = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgMutiPicLayout.this.aiz != null) {
                MutiImgMutiPicLayout.this.aiz.b(view, this.currentIndex, this.hasMore && this.aiB);
            }
        }
    }
}
