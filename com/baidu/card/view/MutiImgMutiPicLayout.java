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
    public TextView KA;
    private com.baidu.tbadk.core.data.a Kc;
    private z<com.baidu.tbadk.core.data.a> LD;
    private boolean NJ;
    private TbImageView.c NT;
    public PlayVoiceBntNew NY;
    private boolean Oa;
    private boolean Ob;
    private LinkedList<MediaData> Oc;
    private int Oj;
    private d Ok;
    public RelativeLayout Oo;
    public TbImageView Op;
    public TbImageView Oq;
    public TbImageView Or;
    private TextView Ot;
    protected boolean Ou;
    private String mFrom;
    private int mLastScreenWidth;
    public TextView mTitle;
    private static final int NV = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int NW = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int NX = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int Ky = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgMutiPicLayout(Context context) {
        this(context, null);
    }

    public MutiImgMutiPicLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.NJ = true;
        this.Kc = null;
        this.Oa = false;
        this.Ob = false;
        this.Oj = 0;
        this.Ou = false;
        this.mLastScreenWidth = 0;
        this.NT = new TbImageView.c() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.3
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
                    com.baidu.adp.widget.ImageView.a vx = c.aPO().vx(com.baidu.adp.lib.e.c.gr().genCacheKey(tbImageView.getUrl(), MutiImgMutiPicLayout.this.NJ ? 13 : 14));
                    if (vx != null) {
                        int width = vx.getWidth();
                        i = vx.getHeight();
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
                            if (MutiImgMutiPicLayout.this.Ou && i > i2) {
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
        this.KA = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.NY = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.NY.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgMutiPicLayout.this.Kc);
                }
            }
        });
        this.Oo = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        this.Op = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.Op.setDrawCorner(true);
        this.Op.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.Op.setPlaceHolder(2);
        this.Op.setConrers(15);
        this.Oq = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.Oq.setDrawCorner(false);
        this.Oq.setPlaceHolder(2);
        this.Oq.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.Oq.setConrers(15);
        this.Or = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.Or.setDrawCorner(true);
        this.Or.setPlaceHolder(2);
        this.Or.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.Or.setConrers(15);
        this.Ot = (TextView) findViewById(R.id.thread_card_img_more_label);
        this.Ok = new d() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                z<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgMutiPicLayout.this.Kc.objType = 2;
                    subClickListener.MU = Boolean.valueOf(z);
                    subClickListener.a(view, MutiImgMutiPicLayout.this.Kc);
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().dlW) {
                    au.a(view, MutiImgMutiPicLayout.this.NJ, MutiImgMutiPicLayout.this.Oc, i, MutiImgMutiPicLayout.this.Kc.aAe(), MutiImgMutiPicLayout.this.mFrom);
                } else if ("index".equals(MutiImgMutiPicLayout.this.mFrom)) {
                    au.a(MutiImgMutiPicLayout.this.Kc, view.getContext(), 2, false);
                } else if ("frs".equals(MutiImgMutiPicLayout.this.mFrom)) {
                    au.a(MutiImgMutiPicLayout.this.Kc, view.getContext(), 3, false);
                } else {
                    au.a(view, MutiImgMutiPicLayout.this.NJ, MutiImgMutiPicLayout.this.Oc, i, MutiImgMutiPicLayout.this.Kc.aAe(), MutiImgMutiPicLayout.this.mFrom);
                }
            }
        };
    }

    private void setVoiceData(bj bjVar) {
        ArrayList<VoiceData.VoiceModel> aCA = bjVar.aCA();
        if (v.isEmpty(aCA)) {
            this.NY.setVisibility(8);
            this.Ob = false;
            return;
        }
        this.NY.setVisibility(0);
        VoiceData.VoiceModel voiceModel = aCA.get(0);
        this.NY.setVoiceModel(voiceModel);
        this.NY.setTag(voiceModel);
        this.NY.bHq();
        if (voiceModel != null) {
            this.NY.wW(voiceModel.voice_status.intValue());
        }
        this.NY.cMf();
        this.Ob = true;
    }

    private void setImageData(bj bjVar) {
        boolean z;
        ArrayList<MediaData> aCw = bjVar.aCw();
        if (i.azM().isShowImages() && v.getCount(aCw) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < aCw.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aCw, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.Oc = linkedList;
            this.Oa = true;
            if (linkedList.size() > 3) {
                this.Ot.setText(TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(linkedList.size() - 3)}));
                this.Ot.setVisibility(0);
                z = true;
            } else {
                this.Ot.setVisibility(8);
                z = false;
            }
            this.Oo.setVisibility(8);
            if (v.getCount(linkedList) == 2) {
                this.Oo.setVisibility(0);
                a((MediaData) v.getItem(aCw, 0), this.Op, z, false, 0);
                this.Oq.setVisibility(8);
                a((MediaData) v.getItem(aCw, 1), this.Or, z, false, 1);
                return;
            } else if (v.getCount(linkedList) >= 3) {
                this.Oo.setVisibility(0);
                this.Oq.setVisibility(0);
                a((MediaData) v.getItem(aCw, 0), this.Op, z, false, 0);
                a((MediaData) v.getItem(aCw, 1), this.Oq, z, false, 1);
                a((MediaData) v.getItem(aCw, 2), this.Or, z, true, 2);
                return;
            } else {
                this.Oo.setVisibility(8);
                this.Oa = false;
                return;
            }
        }
        this.Oo.setVisibility(8);
        this.Oa = false;
    }

    public void setFromCDN(boolean z) {
        this.NJ = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.Kc = aVar;
        bj aAe = aVar.aAe();
        au.a(this.mTitle, aAe);
        au.a(this.KA, this.mTitle, aAe, Ky);
        setImageData(aAe);
        setVoiceData(aAe);
        nn();
    }

    private void nn() {
        if (this.KA.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.Oa) {
                setMarginsTop(this.NY, NV);
            } else if (this.Ob) {
                setMarginsTop(this.NY, NX);
            }
        } else if (this.NY != null && this.NY.getLayoutParams() != null) {
            if (this.Oa) {
                setMarginsTop(this.NY, NV);
            } else if (this.Ob) {
                setMarginsTop(this.NY, NW);
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
        return this.LD;
    }

    public void setSubClickListener(z<com.baidu.tbadk.core.data.a> zVar) {
        this.LD = zVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bb = bb(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Op.getLayoutParams();
        layoutParams.width = bb;
        layoutParams.height = bb;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.Oq.getLayoutParams();
        layoutParams2.width = bb;
        layoutParams2.height = bb;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.Or.getLayoutParams();
        layoutParams3.width = bb;
        layoutParams3.height = bb;
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.Ot.getLayoutParams();
        layoutParams4.width = bb;
        layoutParams4.height = bb;
        if (this.Oo.getVisibility() != 8) {
            this.Op.setLayoutParams(layoutParams);
            this.Oq.setLayoutParams(layoutParams2);
            this.Or.setLayoutParams(layoutParams3);
            this.Ot.setLayoutParams(layoutParams4);
        }
    }

    private int bb(int i) {
        if (this.Oj > 0) {
            int equipmentWidth = l.getEquipmentWidth(getContext());
            if (equipmentWidth == this.mLastScreenWidth) {
                return this.Oj;
            }
            this.mLastScreenWidth = equipmentWidth;
        }
        this.Oj = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.Oj;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, int i) {
        String a2 = a(mediaData);
        int i2 = this.NJ ? 13 : 14;
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
        tbImageView.setOnDrawListener(this.NT);
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
        this.Ou = z;
    }

    private void a(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.Ok != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.Ok == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        private boolean Om;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.Om = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgMutiPicLayout.this.Ok != null) {
                MutiImgMutiPicLayout.this.Ok.b(view, this.currentIndex, this.hasMore && this.Om);
            }
        }
    }
}
