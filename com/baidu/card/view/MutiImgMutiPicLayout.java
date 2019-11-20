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
import com.baidu.card.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tbadk.util.e;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MutiImgMutiPicLayout extends LinearLayout implements i<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a EX;
    public TextView Fk;
    private ab<com.baidu.tbadk.core.data.a> Gd;
    private TbImageView.b HC;
    public PlayVoiceBntNew HH;
    private boolean HJ;
    private boolean HK;
    private LinkedList<MediaData> HL;
    private int HR;
    private d HS;
    public RelativeLayout HW;
    public TbImageView HX;
    public TbImageView HY;
    public TbImageView HZ;
    private boolean Hx;
    private TextView Ib;
    protected boolean Ic;
    private String mFrom;
    private int mLastScreenWidth;
    public TextView mTitle;
    private static final int HE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int HF = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int HG = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int Fi = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgMutiPicLayout(Context context) {
        this(context, null);
    }

    public MutiImgMutiPicLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hx = true;
        this.EX = null;
        this.HJ = false;
        this.HK = false;
        this.HR = 0;
        this.Ic = false;
        this.mLastScreenWidth = 0;
        this.HC = new TbImageView.b() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.3
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
                    com.baidu.adp.widget.ImageView.a pY = c.avs().pY(com.baidu.adp.lib.f.c.fT().genCacheKey(tbImageView.getUrl(), MutiImgMutiPicLayout.this.Hx ? 13 : 14));
                    if (pY != null) {
                        int width = pY.getWidth();
                        i = pY.getHeight();
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
                            if (MutiImgMutiPicLayout.this.Ic && i > i2) {
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
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_more_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.Fk = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.HH = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.HH.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgMutiPicLayout.this.EX);
                }
            }
        });
        this.HW = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        this.HX = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.HX.setDrawCorner(true);
        this.HX.setRadius(l.getDimens(getContext(), R.dimen.tbds20));
        this.HX.setDefaultBgResource(e.Vj());
        this.HX.setConrers(5);
        this.HY = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.HY.setDrawCorner(false);
        this.HY.setDefaultBgResource(e.Vj());
        this.HY.setRadius(0);
        this.HY.setConrers(0);
        this.HZ = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.HZ.setDrawCorner(true);
        this.HZ.setDefaultBgResource(e.Vj());
        this.HZ.setRadius(l.getDimens(getContext(), R.dimen.tbds20));
        this.HZ.setConrers(10);
        this.Ib = (TextView) findViewById(R.id.thread_card_img_more_label);
        this.HS = new d() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgMutiPicLayout.this.EX.objType = 2;
                    subClickListener.Hc = Boolean.valueOf(z);
                    subClickListener.a(view, MutiImgMutiPicLayout.this.EX);
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().ctS) {
                    au.a(view, MutiImgMutiPicLayout.this.Hx, MutiImgMutiPicLayout.this.HL, i, MutiImgMutiPicLayout.this.EX.agG(), MutiImgMutiPicLayout.this.mFrom);
                } else if ("index".equals(MutiImgMutiPicLayout.this.mFrom)) {
                    au.a(MutiImgMutiPicLayout.this.EX, view.getContext(), 2, false);
                } else if ("frs".equals(MutiImgMutiPicLayout.this.mFrom)) {
                    au.a(MutiImgMutiPicLayout.this.EX, view.getContext(), 3, false);
                } else {
                    au.a(view, MutiImgMutiPicLayout.this.Hx, MutiImgMutiPicLayout.this.HL, i, MutiImgMutiPicLayout.this.EX.agG(), MutiImgMutiPicLayout.this.mFrom);
                }
            }
        };
    }

    private void setVoiceData(bh bhVar) {
        ArrayList<VoiceData.VoiceModel> aiS = bhVar.aiS();
        if (v.isEmpty(aiS)) {
            this.HH.setVisibility(8);
            this.HK = false;
            return;
        }
        this.HH.setVisibility(0);
        VoiceData.VoiceModel voiceModel = aiS.get(0);
        this.HH.setVoiceModel(voiceModel);
        this.HH.setTag(voiceModel);
        this.HH.bno();
        if (voiceModel != null) {
            this.HH.uJ(voiceModel.voice_status.intValue());
        }
        this.HH.cpA();
        this.HK = true;
    }

    private void setImageData(bh bhVar) {
        boolean z;
        ArrayList<MediaData> aiO = bhVar.aiO();
        if (com.baidu.tbadk.core.i.ago().isShowImages() && v.getCount(aiO) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < aiO.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aiO, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.HL = linkedList;
            this.HJ = true;
            if (linkedList.size() > 3) {
                this.Ib.setText(TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(linkedList.size() - 3)}));
                this.Ib.setVisibility(0);
                z = true;
            } else {
                this.Ib.setVisibility(8);
                z = false;
            }
            this.HW.setVisibility(8);
            if (v.getCount(linkedList) == 2) {
                this.HW.setVisibility(0);
                a((MediaData) v.getItem(aiO, 0), this.HX, z, false, 0);
                this.HY.setVisibility(8);
                a((MediaData) v.getItem(aiO, 1), this.HZ, z, false, 1);
                return;
            } else if (v.getCount(linkedList) >= 3) {
                this.HW.setVisibility(0);
                this.HY.setVisibility(0);
                a((MediaData) v.getItem(aiO, 0), this.HX, z, false, 0);
                a((MediaData) v.getItem(aiO, 1), this.HY, z, false, 1);
                a((MediaData) v.getItem(aiO, 2), this.HZ, z, true, 2);
                return;
            } else {
                this.HW.setVisibility(8);
                this.HJ = false;
                return;
            }
        }
        this.HW.setVisibility(8);
        this.HJ = false;
    }

    public void setFromCDN(boolean z) {
        this.Hx = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void z(com.baidu.tbadk.core.data.a aVar) {
        this.EX = aVar;
        bh agG = aVar.agG();
        au.a(this.mTitle, agG);
        au.a(this.Fk, this.mTitle, agG, Fi);
        setImageData(agG);
        setVoiceData(agG);
        lZ();
    }

    private void lZ() {
        if (this.Fk.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.HJ) {
                setMarginsTop(this.HH, HE);
            } else if (this.HK) {
                setMarginsTop(this.HH, HG);
            }
        } else if (this.HH != null && this.HH.getLayoutParams() != null) {
            if (this.HJ) {
                setMarginsTop(this.HH, HE);
            } else if (this.HK) {
                setMarginsTop(this.HH, HF);
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

    public ab<com.baidu.tbadk.core.data.a> getSubClickListener() {
        return this.Gd;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.Gd = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int aO = aO(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.HX.getLayoutParams();
        layoutParams.width = aO;
        layoutParams.height = aO;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.HY.getLayoutParams();
        layoutParams2.width = aO;
        layoutParams2.height = aO;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.HZ.getLayoutParams();
        layoutParams3.width = aO;
        layoutParams3.height = aO;
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.Ib.getLayoutParams();
        layoutParams4.width = aO;
        layoutParams4.height = aO;
        if (this.HW.getVisibility() != 8) {
            this.HX.setLayoutParams(layoutParams);
            this.HY.setLayoutParams(layoutParams2);
            this.HZ.setLayoutParams(layoutParams3);
            this.Ib.setLayoutParams(layoutParams4);
        }
    }

    private int aO(int i) {
        if (this.HR > 0) {
            int equipmentWidth = l.getEquipmentWidth(getContext());
            if (equipmentWidth == this.mLastScreenWidth) {
                return this.HR;
            }
            this.mLastScreenWidth = equipmentWidth;
        }
        this.HR = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.HR;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, int i) {
        String a2 = a(mediaData);
        int i2 = this.Hx ? 13 : 14;
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
        tbImageView.setBorderColor(am.getColor(R.color.black_alpha8));
        tbImageView.setBorderSurroundContent(true);
        tbImageView.setDrawBorder(true);
        tbImageView.setOnDrawListener(this.HC);
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
        this.Ic = z;
    }

    private void a(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.HS != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.HS == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private boolean HV;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.HV = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgMutiPicLayout.this.HS != null) {
                MutiImgMutiPicLayout.this.HS.b(view, this.currentIndex, this.hasMore && this.HV);
            }
        }
    }
}
