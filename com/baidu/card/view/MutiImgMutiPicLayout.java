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
import com.baidu.card.al;
import com.baidu.card.p;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes21.dex */
public class MutiImgMutiPicLayout extends LinearLayout implements p<AbsThreadDataSupport> {
    private AbsThreadDataSupport afH;
    public TextView agl;
    private aa<AbsThreadDataSupport> ahu;
    private boolean aij;
    public RelativeLayout akC;
    public TbImageView akD;
    public TbImageView akE;
    public TbImageView akF;
    private TextView akG;
    private int akI;
    private d akJ;
    protected boolean akK;
    private boolean akj;
    private TbImageView.c akr;
    public PlayVoiceBntNew akv;
    private boolean akx;
    private boolean aky;
    private LinkedList<MediaData> akz;
    private String mFrom;
    private int mLastScreenWidth;
    public TextView mTitle;
    private static final int akt = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int agq = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int aku = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int agj = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgMutiPicLayout(Context context) {
        this(context, null);
    }

    public MutiImgMutiPicLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akj = true;
        this.afH = null;
        this.akx = false;
        this.aky = false;
        this.akI = 0;
        this.akK = false;
        this.mLastScreenWidth = 0;
        this.aij = false;
        this.akr = new TbImageView.c() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.3
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
                    com.baidu.adp.widget.ImageView.a Du = c.bwL().Du(com.baidu.adp.lib.e.c.mS().genCacheKey(tbImageView.getUrl(), MutiImgMutiPicLayout.this.akj ? 13 : 14));
                    if (Du != null) {
                        int width = Du.getWidth();
                        i = Du.getHeight();
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
                            if (MutiImgMutiPicLayout.this.akK && i > i2) {
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
        this.agl = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.akv = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.akv.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgMutiPicLayout.this.afH);
                }
            }
        });
        int equipmentWidth = ((l.getEquipmentWidth(getContext()) - (al.ahD * 2)) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
        this.akC = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        com.baidu.tbadk.a.b.a.d(this.akC, R.dimen.tbds26, R.dimen.tbds14);
        com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
        com.baidu.tbadk.a.b.a.a(this.agl, R.dimen.tbds7, R.dimen.tbds10);
        this.akC.getLayoutParams().height = equipmentWidth;
        this.akD = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.akD.setDrawCorner(true);
        this.akD.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.akD.setPlaceHolder(2);
        this.akD.setConrers(15);
        this.akD.getLayoutParams().height = equipmentWidth;
        this.akD.getLayoutParams().width = equipmentWidth;
        this.akE = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.akE.setDrawCorner(false);
        this.akE.setPlaceHolder(2);
        this.akE.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.akE.setConrers(15);
        this.akE.getLayoutParams().height = equipmentWidth;
        this.akE.getLayoutParams().width = equipmentWidth;
        this.akF = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.akF.setDrawCorner(true);
        this.akF.setPlaceHolder(2);
        this.akF.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.akF.setConrers(15);
        this.akF.getLayoutParams().height = equipmentWidth;
        this.akF.getLayoutParams().width = equipmentWidth;
        this.akG = (TextView) findViewById(R.id.thread_card_img_more_label);
        this.akG.getLayoutParams().height = equipmentWidth;
        this.akG.getLayoutParams().width = equipmentWidth;
        this.akJ = new d() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                aa<AbsThreadDataSupport> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgMutiPicLayout.this.afH.objType = 2;
                    subClickListener.aiI = Boolean.valueOf(z);
                    subClickListener.a(view, MutiImgMutiPicLayout.this.afH);
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().eOk) {
                    ay.a(view, MutiImgMutiPicLayout.this.akj, MutiImgMutiPicLayout.this.akz, i, MutiImgMutiPicLayout.this.afH.bfG(), MutiImgMutiPicLayout.this.mFrom);
                } else if ("index".equals(MutiImgMutiPicLayout.this.mFrom)) {
                    ay.a(MutiImgMutiPicLayout.this.afH, view.getContext(), 2, false);
                } else if ("frs".equals(MutiImgMutiPicLayout.this.mFrom)) {
                    ay.a(MutiImgMutiPicLayout.this.afH, view.getContext(), 3, false);
                } else {
                    ay.a(view, MutiImgMutiPicLayout.this.akj, MutiImgMutiPicLayout.this.akz, i, MutiImgMutiPicLayout.this.afH.bfG(), MutiImgMutiPicLayout.this.mFrom);
                }
            }
        };
    }

    private void setVoiceData(bw bwVar) {
        ArrayList<VoiceData.VoiceModel> biu = bwVar.biu();
        if (y.isEmpty(biu)) {
            this.akv.setVisibility(8);
            this.aky = false;
            return;
        }
        this.akv.setVisibility(0);
        VoiceData.VoiceModel voiceModel = biu.get(0);
        this.akv.setVoiceModel(voiceModel);
        this.akv.setTag(voiceModel);
        this.akv.changeSkin();
        if (voiceModel != null) {
            this.akv.CT(voiceModel.voice_status.intValue());
        }
        this.akv.bTK();
        this.aky = true;
    }

    private void setImageData(bw bwVar) {
        boolean z;
        ArrayList<MediaData> biq = bwVar.biq();
        if (k.bfo().isShowImages() && y.getCount(biq) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < biq.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(biq, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.akz = linkedList;
            this.akx = true;
            com.baidu.tbadk.a.b.a.h(this.akG, R.drawable.thread_card_more_number_bg);
            if (linkedList.size() > 3) {
                this.akG.setText(TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(linkedList.size() - 3)}));
                this.akG.setVisibility(0);
                z = true;
            } else {
                this.akG.setVisibility(8);
                z = false;
            }
            this.akC.setVisibility(8);
            if (y.getCount(linkedList) == 2) {
                this.akC.setVisibility(0);
                a((MediaData) y.getItem(biq, 0), this.akD, z, false, 0);
                this.akE.setVisibility(8);
                a((MediaData) y.getItem(biq, 1), this.akF, z, false, 1);
                return;
            } else if (y.getCount(linkedList) >= 3) {
                this.akC.setVisibility(0);
                this.akE.setVisibility(0);
                a((MediaData) y.getItem(biq, 0), this.akD, z, false, 0);
                a((MediaData) y.getItem(biq, 1), this.akE, z, false, 1);
                a((MediaData) y.getItem(biq, 2), this.akF, z, true, 2);
                return;
            } else {
                this.akC.setVisibility(8);
                this.akx = false;
                return;
            }
        }
        this.akC.setVisibility(8);
        this.akx = false;
    }

    public void setFromCDN(boolean z) {
        this.akj = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        this.afH = absThreadDataSupport;
        bw bfG = absThreadDataSupport.bfG();
        ay.a(this.mTitle, bfG, this.aij);
        ay.a(this.agl, this.mTitle, bfG, agj, this.aij);
        setImageData(bfG);
        setVoiceData(bfG);
        ua();
    }

    private void ua() {
        if (this.agl.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.akx) {
                setMarginsTop(this.akv, akt);
            } else if (this.aky) {
                setMarginsTop(this.akv, aku);
            }
        } else if (this.akv != null && this.akv.getLayoutParams() != null) {
            if (this.akx) {
                setMarginsTop(this.akv, akt);
            } else if (this.aky) {
                setMarginsTop(this.akv, agq);
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
        return this.ahu;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.ahu = aaVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bE = bE(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.akD.getLayoutParams();
        layoutParams.width = bE;
        layoutParams.height = bE;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.akE.getLayoutParams();
        layoutParams2.width = bE;
        layoutParams2.height = bE;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.akF.getLayoutParams();
        layoutParams3.width = bE;
        layoutParams3.height = bE;
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.akG.getLayoutParams();
        layoutParams4.width = bE;
        layoutParams4.height = bE;
        if (this.akC.getVisibility() != 8) {
            this.akD.setLayoutParams(layoutParams);
            this.akE.setLayoutParams(layoutParams2);
            this.akF.setLayoutParams(layoutParams3);
            this.akG.setLayoutParams(layoutParams4);
        }
    }

    private int bE(int i) {
        if (this.akI > 0) {
            int equipmentWidth = l.getEquipmentWidth(getContext());
            if (equipmentWidth == this.mLastScreenWidth) {
                return this.akI;
            }
            this.mLastScreenWidth = equipmentWidth;
        }
        this.akI = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.akI;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, int i) {
        String a2 = a(mediaData);
        int i2 = this.akj ? 13 : 14;
        if (!at.equals(a2, tbImageView.getUrl())) {
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
        tbImageView.setBorderColor(ap.getColor(R.color.cp_border_a));
        tbImageView.setBorderSurroundContent(true);
        tbImageView.setDrawBorder(true);
        tbImageView.setOnDrawListener(this.akr);
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
        this.akK = z;
    }

    private void a(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.akJ != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.akJ == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.aij = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a implements View.OnClickListener {
        private boolean akM;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.akM = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgMutiPicLayout.this.akJ != null) {
                MutiImgMutiPicLayout.this.akJ.b(view, this.currentIndex, this.hasMore && this.akM);
            }
        }
    }
}
