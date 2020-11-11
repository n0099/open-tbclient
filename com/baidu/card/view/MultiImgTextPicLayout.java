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
import com.baidu.tieba.card.ab;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes21.dex */
public class MultiImgTextPicLayout extends LinearLayout implements p<AbsThreadDataSupport> {
    private AbsThreadDataSupport afI;
    public TextView agm;
    private ab<AbsThreadDataSupport> ahv;
    private boolean aik;
    private LinkedList<MediaData> akA;
    public RelativeLayout akD;
    public TbImageView akE;
    public TbImageView akF;
    public TbImageView akG;
    private TextView akH;
    public TbImageView akI;
    private int akJ;
    private d akK;
    protected boolean akL;
    private boolean akk;
    private TbImageView.c aks;
    public PlayVoiceBntNew akw;
    private boolean aky;
    private boolean akz;
    private String mFrom;
    private int mLastScreenWidth;
    public TextView mTitle;
    private static final int aku = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int agr = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int akv = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int agk = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MultiImgTextPicLayout(Context context) {
        this(context, null);
    }

    public MultiImgTextPicLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akk = true;
        this.afI = null;
        this.aky = false;
        this.akz = false;
        this.akJ = 0;
        this.akL = false;
        this.mLastScreenWidth = 0;
        this.aik = false;
        this.aks = new TbImageView.c() { // from class: com.baidu.card.view.MultiImgTextPicLayout.3
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
                    com.baidu.adp.widget.ImageView.a Eb = c.bBd().Eb(com.baidu.adp.lib.e.c.mS().genCacheKey(tbImageView.getUrl(), MultiImgTextPicLayout.this.akk ? 13 : 14));
                    if (Eb != null) {
                        int width = Eb.getWidth();
                        i = Eb.getHeight();
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
                            if (MultiImgTextPicLayout.this.akL && i > i2) {
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
        this.agm = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.akw = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.akw.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MultiImgTextPicLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<AbsThreadDataSupport> subClickListener = MultiImgTextPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MultiImgTextPicLayout.this.afI);
                }
            }
        });
        int equipmentWidth = ((l.getEquipmentWidth(getContext()) - (al.ahE * 2)) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
        this.akD = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        com.baidu.tbadk.a.b.a.d(this.akD, R.dimen.tbds26, R.dimen.tbds14);
        com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
        com.baidu.tbadk.a.b.a.a(this.agm, R.dimen.tbds7, R.dimen.tbds10);
        this.akD.getLayoutParams().height = equipmentWidth;
        this.akE = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.akE.setDrawCorner(true);
        this.akE.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.akE.setPlaceHolder(2);
        this.akE.setConrers(15);
        this.akE.getLayoutParams().height = equipmentWidth;
        this.akE.getLayoutParams().width = equipmentWidth;
        this.akF = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.akF.setDrawCorner(false);
        this.akF.setPlaceHolder(2);
        this.akF.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.akF.setConrers(15);
        this.akF.getLayoutParams().height = equipmentWidth;
        this.akF.getLayoutParams().width = equipmentWidth;
        this.akG = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.akG.setDrawCorner(true);
        this.akG.setPlaceHolder(2);
        this.akG.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.akG.setConrers(15);
        this.akG.getLayoutParams().height = equipmentWidth;
        this.akG.getLayoutParams().width = equipmentWidth;
        this.akH = (TextView) findViewById(R.id.thread_card_img_more_label);
        this.akH.getLayoutParams().height = equipmentWidth;
        this.akH.getLayoutParams().width = equipmentWidth;
        this.akI = (TbImageView) findViewById(R.id.thread_card_img_singal);
        this.akI.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.akI.setConrers(15);
        this.akI.setDrawCorner(true);
        this.akI.setPlaceHolder(3);
        this.akI.setLongIconSupport(true);
        this.akI.setGifIconSupport(true);
        com.baidu.tbadk.a.b.a.d(this.akI, R.dimen.tbds28, R.dimen.tbds14);
        this.akK = new d() { // from class: com.baidu.card.view.MultiImgTextPicLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                ab<AbsThreadDataSupport> subClickListener = MultiImgTextPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MultiImgTextPicLayout.this.afI.objType = 2;
                    subClickListener.aiJ = Boolean.valueOf(z);
                    subClickListener.a(view, MultiImgTextPicLayout.this.afI);
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().fcw) {
                    ay.a(view, MultiImgTextPicLayout.this.akk, MultiImgTextPicLayout.this.akA, i, MultiImgTextPicLayout.this.afI.bjZ(), MultiImgTextPicLayout.this.mFrom);
                } else if ("index".equals(MultiImgTextPicLayout.this.mFrom)) {
                    ay.a(MultiImgTextPicLayout.this.afI, view.getContext(), 2, false);
                } else if ("frs".equals(MultiImgTextPicLayout.this.mFrom)) {
                    ay.a(MultiImgTextPicLayout.this.afI, view.getContext(), 3, false);
                } else {
                    ay.a(view, MultiImgTextPicLayout.this.akk, MultiImgTextPicLayout.this.akA, i, MultiImgTextPicLayout.this.afI.bjZ(), MultiImgTextPicLayout.this.mFrom);
                }
            }
        };
    }

    private void setVoiceData(bw bwVar) {
        ArrayList<VoiceData.VoiceModel> bmN = bwVar.bmN();
        if (y.isEmpty(bmN)) {
            this.akw.setVisibility(8);
            this.akz = false;
            return;
        }
        this.akw.setVisibility(0);
        VoiceData.VoiceModel voiceModel = bmN.get(0);
        this.akw.setVoiceModel(voiceModel);
        this.akw.setTag(voiceModel);
        this.akw.changeSkin();
        if (voiceModel != null) {
            this.akw.Dz(voiceModel.voice_status.intValue());
        }
        this.akw.bZl();
        this.akz = true;
    }

    private void setSingleImgData(bw bwVar) {
        MediaData mediaData;
        this.akH.setVisibility(8);
        this.akD.setVisibility(8);
        ArrayList<MediaData> bmJ = bwVar.bmJ();
        if (k.bjH().isShowImages() && y.getCount(bmJ) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            MediaData mediaData2 = null;
            int i = 0;
            while (true) {
                if (i >= bmJ.size()) {
                    mediaData = mediaData2;
                    break;
                }
                mediaData2 = (MediaData) y.getItem(bmJ, i);
                if (mediaData2 == null || mediaData2.getType() != 3) {
                    i++;
                } else {
                    linkedList.add(mediaData2);
                    mediaData = mediaData2;
                    break;
                }
            }
            this.akA = linkedList;
            this.aky = true;
            this.akI.setVisibility(8);
            if (y.getCount(linkedList) == 1) {
                this.akI.setVisibility(0);
                a(mediaData, this.akI, false, false, 0);
                return;
            }
            this.akI.setVisibility(8);
            this.aky = false;
            return;
        }
        this.akI.setVisibility(8);
        this.aky = false;
    }

    private void setImageData(bw bwVar) {
        boolean z;
        ArrayList<MediaData> bmJ = bwVar.bmJ();
        if (k.bjH().isShowImages() && y.getCount(bmJ) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < bmJ.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(bmJ, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.akA = linkedList;
            this.aky = true;
            if (linkedList.size() == 1) {
                this.akH.setVisibility(8);
                this.akD.setVisibility(8);
                this.akI.setVisibility(0);
                a((MediaData) y.getItem(bmJ, 0), this.akI, false, false, 0);
                return;
            }
            this.akI.setVisibility(8);
            com.baidu.tbadk.a.b.a.h(this.akH, R.drawable.thread_card_more_number_bg);
            if (linkedList.size() > 3) {
                this.akH.setText(TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(linkedList.size() - 3)}));
                this.akH.setVisibility(0);
                z = true;
            } else {
                this.akH.setVisibility(8);
                z = false;
            }
            this.akD.setVisibility(8);
            if (y.getCount(linkedList) == 2) {
                this.akD.setVisibility(0);
                a((MediaData) y.getItem(bmJ, 0), this.akE, z, false, 0);
                this.akF.setVisibility(8);
                a((MediaData) y.getItem(bmJ, 1), this.akG, z, false, 1);
                return;
            } else if (y.getCount(linkedList) >= 3) {
                this.akD.setVisibility(0);
                this.akF.setVisibility(0);
                a((MediaData) y.getItem(bmJ, 0), this.akE, z, false, 0);
                a((MediaData) y.getItem(bmJ, 1), this.akF, z, false, 1);
                a((MediaData) y.getItem(bmJ, 2), this.akG, z, true, 2);
                return;
            } else {
                this.akD.setVisibility(8);
                this.aky = false;
                return;
            }
        }
        this.akD.setVisibility(8);
        this.aky = false;
    }

    private void setImageTextData(bw bwVar) {
    }

    public void setFromCDN(boolean z) {
        this.akk = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        this.afI = absThreadDataSupport;
        bw bjZ = absThreadDataSupport.bjZ();
        ay.a(this.mTitle, bjZ, this.aik);
        ay.a(this.agm, this.mTitle, bjZ, agk, this.aik);
        setImageData(bjZ);
        setVoiceData(bjZ);
        ua();
    }

    private void ua() {
        if (this.agm.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.aky) {
                setMarginsTop(this.akw, aku);
            } else if (this.akz) {
                setMarginsTop(this.akw, akv);
            }
        } else if (this.akw != null && this.akw.getLayoutParams() != null) {
            if (this.aky) {
                setMarginsTop(this.akw, aku);
            } else if (this.akz) {
                setMarginsTop(this.akw, agr);
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

    public ab<AbsThreadDataSupport> getSubClickListener() {
        return this.ahv;
    }

    public void setSubClickListener(ab<AbsThreadDataSupport> abVar) {
        this.ahv = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bE = bE(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.akE.getLayoutParams();
        layoutParams.width = bE;
        layoutParams.height = bE;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.akF.getLayoutParams();
        layoutParams2.width = bE;
        layoutParams2.height = bE;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.akG.getLayoutParams();
        layoutParams3.width = bE;
        layoutParams3.height = bE;
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.akH.getLayoutParams();
        layoutParams4.width = bE;
        layoutParams4.height = bE;
        if (this.akD.getVisibility() != 8) {
            this.akE.setLayoutParams(layoutParams);
            this.akF.setLayoutParams(layoutParams2);
            this.akG.setLayoutParams(layoutParams3);
            this.akH.setLayoutParams(layoutParams4);
        }
    }

    private int bE(int i) {
        if (this.akJ > 0) {
            int equipmentWidth = l.getEquipmentWidth(getContext());
            if (equipmentWidth == this.mLastScreenWidth) {
                return this.akJ;
            }
            this.mLastScreenWidth = equipmentWidth;
        }
        this.akJ = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.akJ;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, int i) {
        String a2 = a(mediaData);
        int i2 = this.akk ? 13 : 14;
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
        tbImageView.setOnDrawListener(this.aks);
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
        this.akL = z;
    }

    private void a(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.akK != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.akK == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.aik = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a implements View.OnClickListener {
        private boolean akN;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.akN = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MultiImgTextPicLayout.this.akK != null) {
                MultiImgTextPicLayout.this.akK.b(view, this.currentIndex, this.hasMore && this.akN);
            }
        }
    }
}
