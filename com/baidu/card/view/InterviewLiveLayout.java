package com.baidu.card.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.card.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes15.dex */
public class InterviewLiveLayout extends FrameLayout implements n<AbsThreadDataSupport> {
    private AbsThreadDataSupport adQ;
    private aa<AbsThreadDataSupport> afy;
    private boolean aib;
    private TbImageView aic;
    private LinearLayout aie;
    private ImageView aif;
    private TextView aig;
    private ArrayList<String> aih;
    private bv aii;
    private View.OnClickListener aij;
    private TbImageView.c aik;
    private long forumId;
    private int mSkinType;
    private String taskId;

    public InterviewLiveLayout(Context context) {
        this(context, null);
    }

    public InterviewLiveLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aib = true;
        this.adQ = null;
        this.aih = new ArrayList<>();
        this.aij = new View.OnClickListener() { // from class: com.baidu.card.view.InterviewLiveLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (x.getCount(InterviewLiveLayout.this.aih) > 0) {
                    if (TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
                        String str = (String) InterviewLiveLayout.this.aih.get(0);
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.urlType = InterviewLiveLayout.this.aib ? 13 : 14;
                        imageUrlData.imageUrl = str;
                        imageUrlData.originalUrl = str;
                        imageUrlData.originalSize = 0L;
                        imageUrlData.isLongPic = false;
                        imageUrlData.mIsShowOrigonButton = false;
                        imageUrlData.threadId = 0L;
                        imageUrlData.postId = 0L;
                        concurrentHashMap.put(str, imageUrlData);
                        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                        aVar.s(InterviewLiveLayout.this.aih).hl(InterviewLiveLayout.this.aib).wH(str).hm(false).a(concurrentHashMap).hn(false).r(InterviewLiveLayout.this.aii).hr(false);
                        ImageViewerConfig dI = aVar.dI(InterviewLiveLayout.this.getContext());
                        dI.getIntent().putExtra("from", "frs");
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        dI.getIntent().putExtra("source_rect_in_screen", rect);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dI));
                        ap apVar = new ap("c13327");
                        apVar.t("fid", InterviewLiveLayout.this.forumId);
                        apVar.dn("obj_id", InterviewLiveLayout.this.taskId);
                        TiebaStatic.log(apVar);
                        if (InterviewLiveLayout.this.afy != null) {
                            InterviewLiveLayout.this.afy.a(InterviewLiveLayout.this.aic, InterviewLiveLayout.this.adQ);
                            return;
                        }
                        return;
                    }
                    l.showToast(InterviewLiveLayout.this.getContext(), R.string.plugin_image_viewer_install_error_tips);
                }
            }
        };
        this.aik = new TbImageView.c() { // from class: com.baidu.card.view.InterviewLiveLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                int i2;
                float f;
                float f2;
                float f3;
                float f4;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a zV = c.bkk().zV(com.baidu.adp.lib.e.c.ln().genCacheKey(tbImageView.getUrl(), InterviewLiveLayout.this.aib ? 13 : 14));
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
                        if (tbImageView.isLongPic() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i2 * height > width2 * i) {
                                f4 = height / i;
                            } else {
                                f4 = width2 / i2;
                            }
                            imageMatrix.setScale(f4, f4);
                            imageMatrix.postTranslate(0.0f, 0.0f);
                        } else if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i2 * height > width2 * i) {
                                float f5 = height / i;
                                f2 = f5;
                                f3 = (width2 - (i2 * f5)) * 0.5f;
                                f = 0.0f;
                            } else {
                                float f6 = width2 / i2;
                                f = (height - (i * f6)) * 0.5f;
                                f2 = f6;
                                f3 = 0.0f;
                            }
                            imageMatrix.setScale(f2, f2);
                            if (i > i2) {
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
        LayoutInflater.from(getContext()).inflate(R.layout.interview_live_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.aic = (TbImageView) findViewById(R.id.img_interview_live);
        this.aic.oB(15);
        this.aic.setPlaceHolder(3);
        this.aie = (LinearLayout) findViewById(R.id.interview_live_tip_bg);
        this.aif = (ImageView) findViewById(R.id.interview_live_tip_img);
        this.aig = (TextView) findViewById(R.id.interview_live_tip);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setFromCDN(boolean z) {
        this.aib = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adQ = absThreadDataSupport;
        if (absThreadDataSupport == null || this.aic == null) {
            setVisibility(8);
            return;
        }
        bv aTN = absThreadDataSupport.aTN();
        bt aVR = aTN.aVR();
        if (aVR == null) {
            setVisibility(8);
            return;
        }
        this.aii = aTN;
        this.forumId = aTN.getFid();
        this.taskId = aVR.getTaskId();
        if (k.aTv().isShowImages() && aVR != null && !StringUtils.isNull(aVR.getThreadImgUrl())) {
            this.aih.clear();
            this.aih.add(aVR.getThreadImgUrl());
            setVisibility(0);
            this.aic.setSupportNoImage(true);
            this.aic.setScaleType(ImageView.ScaleType.MATRIX);
            this.aic.setOnDrawListener(this.aik);
            this.aic.startLoad(aVR.getThreadImgUrl(), this.aib ? 13 : 14, false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88);
            layoutParams.height = (int) ((layoutParams.width * 428.0f) / 760.0f);
            setLayoutParams(layoutParams);
        } else {
            setVisibility(8);
        }
        this.aic.setOnClickListener(this.aij);
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.afy = aaVar;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            ao.setViewTextColor(this.aig, R.color.cp_cont_a);
            ao.setImageResource(this.aif, R.drawable.interview_live_circle_share);
            ao.setBackgroundResource(this.aie, R.drawable.interview_live_circle_bg_shape);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.aic != null) {
            this.aic.setPageId(bdUniqueId);
        }
    }
}
