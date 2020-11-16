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
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.k;
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
/* loaded from: classes20.dex */
public class MultiImgTextPicLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
    private static final int agp;
    private static final int akx = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int aky = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int akz = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private com.baidu.tbadk.core.data.a afN;
    public TextView agr;
    private ab<com.baidu.tbadk.core.data.a> ahx;
    private boolean ain;
    public PlayVoiceBntNew akA;
    private boolean akC;
    private boolean akD;
    private LinkedList<MediaData> akE;
    public RelativeLayout akH;
    public TbImageView akI;
    public TbImageView akJ;
    public TbImageView akK;
    private TextView akL;
    public TbImageView akM;
    private int akN;
    private d akO;
    protected boolean akP;
    private boolean akn;
    private TbImageView.c akv;
    private String mFrom;
    private int mLastScreenWidth;
    public TextView mTitle;

    static {
        agp = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.tbadk.a.d.bhw() ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007) * 2 : (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MultiImgTextPicLayout(Context context) {
        this(context, null);
    }

    public MultiImgTextPicLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akn = true;
        this.afN = null;
        this.akC = false;
        this.akD = false;
        this.akN = 0;
        this.akP = false;
        this.mLastScreenWidth = 0;
        this.ain = false;
        this.akv = new TbImageView.c() { // from class: com.baidu.card.view.MultiImgTextPicLayout.3
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
                    com.baidu.adp.widget.ImageView.a DA = c.bAt().DA(com.baidu.adp.lib.e.c.mS().genCacheKey(tbImageView.getUrl(), MultiImgTextPicLayout.this.akn ? 13 : 14));
                    if (DA != null) {
                        int width = DA.getWidth();
                        i = DA.getHeight();
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
                            if (MultiImgTextPicLayout.this.akP && i > i2) {
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
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_card_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.agr = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.akA = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.akA.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MultiImgTextPicLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MultiImgTextPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MultiImgTextPicLayout.this.afN);
                }
            }
        });
        int equipmentWidth = ((l.getEquipmentWidth(getContext()) - (al.ahG * 2)) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
        this.akH = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        com.baidu.tbadk.a.b.a.d(this.akH, R.dimen.tbds26, R.dimen.tbds14);
        com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
        com.baidu.tbadk.a.b.a.a(this.agr, R.dimen.tbds7, R.dimen.tbds10);
        this.akH.getLayoutParams().height = equipmentWidth;
        this.akI = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.akI.setDrawCorner(true);
        this.akI.setRadiusById(R.string.J_X12);
        this.akI.setPlaceHolder(2);
        this.akI.setConrers(15);
        this.akI.getLayoutParams().height = equipmentWidth;
        this.akI.getLayoutParams().width = equipmentWidth;
        this.akJ = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.akJ.setDrawCorner(false);
        this.akJ.setPlaceHolder(2);
        this.akJ.setRadiusById(R.string.J_X02);
        this.akJ.setConrers(15);
        this.akJ.getLayoutParams().height = equipmentWidth;
        this.akJ.getLayoutParams().width = equipmentWidth;
        this.akK = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.akK.setDrawCorner(true);
        this.akK.setPlaceHolder(2);
        this.akK.setRadiusById(R.string.J_X11);
        this.akK.setConrers(15);
        this.akK.getLayoutParams().height = equipmentWidth;
        this.akK.getLayoutParams().width = equipmentWidth;
        this.akL = (TextView) findViewById(R.id.thread_card_img_more_label);
        this.akL.getLayoutParams().height = equipmentWidth;
        this.akL.getLayoutParams().width = equipmentWidth;
        float[] oJ = com.baidu.tbadk.core.elementsMaven.a.oJ(R.array.S_O_X001);
        this.akL.setShadowLayer(oJ[1], oJ[2], oJ[3], (int) oJ[0]);
        this.akM = (TbImageView) findViewById(R.id.thread_card_img_singal);
        this.akM.setRadiusById(R.string.J_X05);
        this.akM.setConrers(15);
        this.akM.setDrawCorner(true);
        this.akM.setPlaceHolder(3);
        this.akM.setLongIconSupport(true);
        this.akM.setGifIconSupport(true);
        com.baidu.tbadk.a.b.a.d(this.akM, R.dimen.tbds28, R.dimen.tbds14);
        this.akO = new d() { // from class: com.baidu.card.view.MultiImgTextPicLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MultiImgTextPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MultiImgTextPicLayout.this.afN.objType = 2;
                    subClickListener.aiO = Boolean.valueOf(z);
                    subClickListener.a(view, MultiImgTextPicLayout.this.afN);
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().fbD) {
                    az.a(view, MultiImgTextPicLayout.this.akn, MultiImgTextPicLayout.this.akE, i, MultiImgTextPicLayout.this.afN.bjd(), MultiImgTextPicLayout.this.mFrom);
                } else if ("index".equals(MultiImgTextPicLayout.this.mFrom)) {
                    az.a(MultiImgTextPicLayout.this.afN, view.getContext(), 2, false);
                } else if ("frs".equals(MultiImgTextPicLayout.this.mFrom)) {
                    az.a(MultiImgTextPicLayout.this.afN, view.getContext(), 3, false);
                } else {
                    az.a(view, MultiImgTextPicLayout.this.akn, MultiImgTextPicLayout.this.akE, i, MultiImgTextPicLayout.this.afN.bjd(), MultiImgTextPicLayout.this.mFrom);
                }
            }
        };
    }

    private void setVoiceData(bx bxVar) {
        ArrayList<VoiceData.VoiceModel> blP = bxVar.blP();
        if (y.isEmpty(blP)) {
            this.akA.setVisibility(8);
            this.akD = false;
            return;
        }
        this.akA.setVisibility(0);
        VoiceData.VoiceModel voiceModel = blP.get(0);
        this.akA.setVoiceModel(voiceModel);
        this.akA.setTag(voiceModel);
        this.akA.changeSkin();
        if (voiceModel != null) {
            this.akA.DX(voiceModel.voice_status.intValue());
        }
        this.akA.bYE();
        this.akD = true;
    }

    private void setSingleImgData(bx bxVar) {
        MediaData mediaData;
        this.akL.setVisibility(8);
        this.akH.setVisibility(8);
        ArrayList<MediaData> blL = bxVar.blL();
        if (k.biL().isShowImages() && y.getCount(blL) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            MediaData mediaData2 = null;
            int i = 0;
            while (true) {
                if (i >= blL.size()) {
                    mediaData = mediaData2;
                    break;
                }
                mediaData2 = (MediaData) y.getItem(blL, i);
                if (mediaData2 == null || mediaData2.getType() != 3) {
                    i++;
                } else {
                    linkedList.add(mediaData2);
                    mediaData = mediaData2;
                    break;
                }
            }
            this.akE = linkedList;
            this.akC = true;
            this.akM.setVisibility(8);
            if (y.getCount(linkedList) == 1) {
                this.akM.setVisibility(0);
                a(mediaData, this.akM, false, false, 0);
                return;
            }
            this.akM.setVisibility(8);
            this.akC = false;
            return;
        }
        this.akM.setVisibility(8);
        this.akC = false;
    }

    private void setImageData(bx bxVar) {
        boolean z;
        ArrayList<MediaData> blL = bxVar.blL();
        if (k.biL().isShowImages() && y.getCount(blL) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < blL.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(blL, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.akE = linkedList;
            this.akC = true;
            if (linkedList.size() == 1) {
                this.akL.setVisibility(8);
                this.akH.setVisibility(8);
                this.akM.setVisibility(0);
                a((MediaData) y.getItem(blL, 0), this.akM, false, false, 0);
                return;
            }
            this.akM.setVisibility(8);
            com.baidu.tbadk.a.b.a.j(this.akL, R.drawable.thread_card_more_number_bg);
            if (linkedList.size() > 3) {
                this.akL.setText(TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(linkedList.size() - 3)}));
                this.akL.setVisibility(0);
                z = true;
            } else {
                this.akL.setVisibility(8);
                z = false;
            }
            this.akH.setVisibility(8);
            if (y.getCount(linkedList) == 2) {
                this.akH.setVisibility(0);
                a((MediaData) y.getItem(blL, 0), this.akI, z, false, 0);
                this.akJ.setVisibility(8);
                a((MediaData) y.getItem(blL, 1), this.akK, z, false, 1);
                return;
            } else if (y.getCount(linkedList) >= 3) {
                this.akH.setVisibility(0);
                this.akJ.setVisibility(0);
                a((MediaData) y.getItem(blL, 0), this.akI, z, false, 0);
                a((MediaData) y.getItem(blL, 1), this.akJ, z, false, 1);
                a((MediaData) y.getItem(blL, 2), this.akK, z, true, 2);
                return;
            } else {
                this.akH.setVisibility(8);
                this.akC = false;
                return;
            }
        }
        this.akH.setVisibility(8);
        this.akC = false;
    }

    private void setImageTextData(bx bxVar) {
    }

    public void setFromCDN(boolean z) {
        this.akn = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        this.afN = aVar;
        bx bjd = aVar.bjd();
        az.a(this.mTitle, bjd, this.ain);
        az.a(this.agr, this.mTitle, bjd, agp, this.ain);
        setImageData(bjd);
        setVoiceData(bjd);
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
        return this.ahx;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.ahx = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bC = bC(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.akI.getLayoutParams();
        layoutParams.width = bC;
        layoutParams.height = bC;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.akJ.getLayoutParams();
        layoutParams2.width = bC;
        layoutParams2.height = bC;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.akK.getLayoutParams();
        layoutParams3.width = bC;
        layoutParams3.height = bC;
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.akL.getLayoutParams();
        layoutParams4.width = bC;
        layoutParams4.height = bC;
        if (this.akH.getVisibility() != 8) {
            this.akI.setLayoutParams(layoutParams);
            this.akJ.setLayoutParams(layoutParams2);
            this.akK.setLayoutParams(layoutParams3);
            this.akL.setLayoutParams(layoutParams4);
        }
    }

    private int bC(int i) {
        if (this.akN > 0) {
            int equipmentWidth = l.getEquipmentWidth(getContext());
            if (equipmentWidth == this.mLastScreenWidth) {
                return this.akN;
            }
            this.mLastScreenWidth = equipmentWidth;
        }
        this.akN = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.akN;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, int i) {
        String a2 = a(mediaData);
        int i2 = this.akn ? 13 : 14;
        if (!au.equals(a2, tbImageView.getUrl())) {
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
        tbImageView.setBorderColor(ap.getColor(R.color.CAM_X0401));
        tbImageView.setBorderSurroundContent(true);
        tbImageView.setDrawBorder(true);
        tbImageView.setOnDrawListener(this.akv);
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
        this.akP = z;
    }

    private void a(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.akO != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.akO == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.ain = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class a implements View.OnClickListener {
        private boolean akR;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.akR = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MultiImgTextPicLayout.this.akO != null) {
                MultiImgTextPicLayout.this.akO.b(view, this.currentIndex, this.hasMore && this.akR);
            }
        }
    }
}
