package com.baidu.card.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.e.d;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.card.p;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class InterviewLiveLayout extends FrameLayout implements p<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a ahi;
    private aa<com.baidu.tbadk.core.data.a> ajj;
    private boolean alQ;
    private TbImageView alR;
    private LinearLayout alS;
    private ImageView alT;
    private TextView alU;
    private ArrayList<String> alV;
    private bz alW;
    private View.OnClickListener alX;
    private TbImageView.c alY;
    private long forumId;
    private int mSkinType;
    private String taskId;

    public InterviewLiveLayout(Context context) {
        this(context, null);
    }

    public InterviewLiveLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.alQ = true;
        this.ahi = null;
        this.alV = new ArrayList<>();
        this.alX = new View.OnClickListener() { // from class: com.baidu.card.view.InterviewLiveLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (x.getCount(InterviewLiveLayout.this.alV) > 0) {
                    if (TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
                        String str = (String) InterviewLiveLayout.this.alV.get(0);
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.urlType = InterviewLiveLayout.this.alQ ? 13 : 14;
                        imageUrlData.imageUrl = str;
                        imageUrlData.originalUrl = str;
                        imageUrlData.originalSize = 0L;
                        imageUrlData.isLongPic = false;
                        imageUrlData.mIsShowOrigonButton = false;
                        imageUrlData.threadId = 0L;
                        imageUrlData.postId = 0L;
                        concurrentHashMap.put(str, imageUrlData);
                        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                        aVar.x(InterviewLiveLayout.this.alV).ji(InterviewLiveLayout.this.alQ).AH(str).jj(false).d(concurrentHashMap).jk(false).s(InterviewLiveLayout.this.alW).jo(false);
                        ImageViewerConfig eS = aVar.eS(InterviewLiveLayout.this.getContext());
                        eS.getIntent().putExtra("from", "frs");
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        eS.getIntent().putExtra("source_rect_in_screen", rect);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eS));
                        aq aqVar = new aq("c13327");
                        aqVar.w("fid", InterviewLiveLayout.this.forumId);
                        aqVar.dX("obj_id", InterviewLiveLayout.this.taskId);
                        TiebaStatic.log(aqVar);
                        if (InterviewLiveLayout.this.ajj != null) {
                            InterviewLiveLayout.this.ajj.a(InterviewLiveLayout.this.alR, InterviewLiveLayout.this.ahi);
                            return;
                        }
                        return;
                    }
                    l.showToast(InterviewLiveLayout.this.getContext(), R.string.plugin_image_viewer_install_error_tips);
                }
            }
        };
        this.alY = new TbImageView.c() { // from class: com.baidu.card.view.InterviewLiveLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                int i2;
                float f;
                float f2;
                float f3;
                float f4;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a Ef = c.bGp().Ef(d.mx().genCacheKey(tbImageView.getUrl(), InterviewLiveLayout.this.alQ ? 13 : 14));
                    if (Ef != null) {
                        int width = Ef.getWidth();
                        i = Ef.getHeight();
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
                                f = height / i;
                                f3 = (width2 - (i2 * f)) * 0.5f;
                                f2 = 0.0f;
                            } else {
                                f = width2 / i2;
                                f2 = (height - (i * f)) * 0.5f;
                                f3 = 0.0f;
                            }
                            imageMatrix.setScale(f, f);
                            if (i > i2) {
                                imageMatrix.postTranslate(f3, 0.0f);
                            } else {
                                imageMatrix.postTranslate(f3, f2);
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
        this.alR = (TbImageView) findViewById(R.id.img_interview_live);
        this.alR.tj(15);
        this.alR.setPlaceHolder(3);
        this.alS = (LinearLayout) findViewById(R.id.interview_live_tip_bg);
        this.alT = (ImageView) findViewById(R.id.interview_live_tip_img);
        this.alU = (TextView) findViewById(R.id.interview_live_tip);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setFromCDN(boolean z) {
        this.alQ = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void D(com.baidu.tbadk.core.data.a aVar) {
        this.ahi = aVar;
        if (aVar == null || this.alR == null) {
            setVisibility(8);
            return;
        }
        bz boO = aVar.boO();
        bx bqW = boO.bqW();
        if (bqW == null) {
            setVisibility(8);
            return;
        }
        this.alW = boO;
        this.forumId = boO.getFid();
        this.taskId = bqW.getTaskId();
        if (k.bou().isShowImages() && bqW != null && !StringUtils.isNull(bqW.getThreadImgUrl())) {
            this.alV.clear();
            this.alV.add(bqW.getThreadImgUrl());
            setVisibility(0);
            this.alR.setSupportNoImage(true);
            this.alR.setScaleType(ImageView.ScaleType.MATRIX);
            this.alR.setOnDrawListener(this.alY);
            this.alR.startLoad(bqW.getThreadImgUrl(), this.alQ ? 13 : 14, false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88);
            layoutParams.height = (int) ((layoutParams.width * 428.0f) / 760.0f);
            setLayoutParams(layoutParams);
        } else {
            setVisibility(8);
        }
        this.alR.setOnClickListener(this.alX);
    }

    public void setSubClickListener(aa<com.baidu.tbadk.core.data.a> aaVar) {
        this.ajj = aaVar;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            ao.setViewTextColor(this.alU, R.color.CAM_X0101);
            ao.setImageResource(this.alT, R.drawable.interview_live_circle_share);
            ao.setBackgroundResource(this.alS, R.drawable.interview_live_circle_bg_shape);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.alR != null) {
            this.alR.setPageId(bdUniqueId);
        }
    }
}
