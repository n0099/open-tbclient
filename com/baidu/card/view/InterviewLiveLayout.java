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
import com.baidu.card.p;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes20.dex */
public class InterviewLiveLayout extends FrameLayout implements p<AbsThreadDataSupport> {
    private AbsThreadDataSupport afq;
    private aa<AbsThreadDataSupport> ahd;
    private boolean ajR;
    private TbImageView ajS;
    private LinearLayout ajT;
    private ImageView ajU;
    private TextView ajV;
    private ArrayList<String> ajW;
    private bw ajX;
    private View.OnClickListener ajY;
    private TbImageView.c ajZ;
    private long forumId;
    private int mSkinType;
    private String taskId;

    public InterviewLiveLayout(Context context) {
        this(context, null);
    }

    public InterviewLiveLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.ajR = true;
        this.afq = null;
        this.ajW = new ArrayList<>();
        this.ajY = new View.OnClickListener() { // from class: com.baidu.card.view.InterviewLiveLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (y.getCount(InterviewLiveLayout.this.ajW) > 0) {
                    if (TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
                        String str = (String) InterviewLiveLayout.this.ajW.get(0);
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.urlType = InterviewLiveLayout.this.ajR ? 13 : 14;
                        imageUrlData.imageUrl = str;
                        imageUrlData.originalUrl = str;
                        imageUrlData.originalSize = 0L;
                        imageUrlData.isLongPic = false;
                        imageUrlData.mIsShowOrigonButton = false;
                        imageUrlData.threadId = 0L;
                        imageUrlData.postId = 0L;
                        concurrentHashMap.put(str, imageUrlData);
                        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                        aVar.x(InterviewLiveLayout.this.ajW).hF(InterviewLiveLayout.this.ajR).zo(str).hG(false).a(concurrentHashMap).hH(false).s(InterviewLiveLayout.this.ajX).hL(false);
                        ImageViewerConfig dO = aVar.dO(InterviewLiveLayout.this.getContext());
                        dO.getIntent().putExtra("from", "frs");
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        dO.getIntent().putExtra("source_rect_in_screen", rect);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dO));
                        aq aqVar = new aq("c13327");
                        aqVar.u("fid", InterviewLiveLayout.this.forumId);
                        aqVar.dF("obj_id", InterviewLiveLayout.this.taskId);
                        TiebaStatic.log(aqVar);
                        if (InterviewLiveLayout.this.ahd != null) {
                            InterviewLiveLayout.this.ahd.a(InterviewLiveLayout.this.ajS, InterviewLiveLayout.this.afq);
                            return;
                        }
                        return;
                    }
                    l.showToast(InterviewLiveLayout.this.getContext(), R.string.plugin_image_viewer_install_error_tips);
                }
            }
        };
        this.ajZ = new TbImageView.c() { // from class: com.baidu.card.view.InterviewLiveLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                int i2;
                float f;
                float f2;
                float f3;
                float f4;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a CI = c.bub().CI(com.baidu.adp.lib.e.c.mR().genCacheKey(tbImageView.getUrl(), InterviewLiveLayout.this.ajR ? 13 : 14));
                    if (CI != null) {
                        int width = CI.getWidth();
                        i = CI.getHeight();
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
        this.ajS = (TbImageView) findViewById(R.id.img_interview_live);
        this.ajS.re(15);
        this.ajS.setPlaceHolder(3);
        this.ajT = (LinearLayout) findViewById(R.id.interview_live_tip_bg);
        this.ajU = (ImageView) findViewById(R.id.interview_live_tip_img);
        this.ajV = (TextView) findViewById(R.id.interview_live_tip);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setFromCDN(boolean z) {
        this.ajR = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void G(AbsThreadDataSupport absThreadDataSupport) {
        this.afq = absThreadDataSupport;
        if (absThreadDataSupport == null || this.ajS == null) {
            setVisibility(8);
            return;
        }
        bw bcY = absThreadDataSupport.bcY();
        bu bfe = bcY.bfe();
        if (bfe == null) {
            setVisibility(8);
            return;
        }
        this.ajX = bcY;
        this.forumId = bcY.getFid();
        this.taskId = bfe.getTaskId();
        if (k.bcG().isShowImages() && bfe != null && !StringUtils.isNull(bfe.getThreadImgUrl())) {
            this.ajW.clear();
            this.ajW.add(bfe.getThreadImgUrl());
            setVisibility(0);
            this.ajS.setSupportNoImage(true);
            this.ajS.setScaleType(ImageView.ScaleType.MATRIX);
            this.ajS.setOnDrawListener(this.ajZ);
            this.ajS.startLoad(bfe.getThreadImgUrl(), this.ajR ? 13 : 14, false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88);
            layoutParams.height = (int) ((layoutParams.width * 428.0f) / 760.0f);
            setLayoutParams(layoutParams);
        } else {
            setVisibility(8);
        }
        this.ajS.setOnClickListener(this.ajY);
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.ahd = aaVar;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            ap.setViewTextColor(this.ajV, R.color.cp_cont_a);
            ap.setImageResource(this.ajU, R.drawable.interview_live_circle_share);
            ap.setBackgroundResource(this.ajT, R.drawable.interview_live_circle_bg_shape);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.ajS != null) {
            this.ajS.setPageId(bdUniqueId);
        }
    }
}
