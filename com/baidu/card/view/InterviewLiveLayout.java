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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class InterviewLiveLayout extends FrameLayout implements n<AbsThreadDataSupport> {
    private AbsThreadDataSupport adw;
    private aa<AbsThreadDataSupport> aeY;
    private boolean aha;
    private TbImageView ahb;
    private LinearLayout ahc;
    private ImageView ahd;
    private TextView ahe;
    private ArrayList<String> ahf;
    private bk ahg;
    private View.OnClickListener ahh;
    private TbImageView.c ahi;
    private long forumId;
    private int mSkinType;
    private String taskId;

    public InterviewLiveLayout(Context context) {
        this(context, null);
    }

    public InterviewLiveLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aha = true;
        this.adw = null;
        this.ahf = new ArrayList<>();
        this.ahh = new View.OnClickListener() { // from class: com.baidu.card.view.InterviewLiveLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (v.getCount(InterviewLiveLayout.this.ahf) > 0) {
                    if (TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
                        String str = (String) InterviewLiveLayout.this.ahf.get(0);
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.urlType = InterviewLiveLayout.this.aha ? 13 : 14;
                        imageUrlData.imageUrl = str;
                        imageUrlData.originalUrl = str;
                        imageUrlData.originalSize = 0L;
                        imageUrlData.isLongPic = false;
                        imageUrlData.mIsShowOrigonButton = false;
                        imageUrlData.threadId = 0L;
                        imageUrlData.postId = 0L;
                        concurrentHashMap.put(str, imageUrlData);
                        ImageViewerConfig createConfig = new ImageViewerConfig(InterviewLiveLayout.this.getContext()).createConfig(InterviewLiveLayout.this.ahf, 0, "", "", "", InterviewLiveLayout.this.aha, str, false, concurrentHashMap, false);
                        createConfig.getIntent().putExtra("from", "frs");
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        createConfig.getIntent().putExtra("source_rect_in_screen", rect);
                        createConfig.setIsShowHost(false);
                        createConfig.setThreadData(InterviewLiveLayout.this.ahg);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                        an anVar = new an("c13327");
                        anVar.s("fid", InterviewLiveLayout.this.forumId);
                        anVar.dh("obj_id", InterviewLiveLayout.this.taskId);
                        TiebaStatic.log(anVar);
                        if (InterviewLiveLayout.this.aeY != null) {
                            InterviewLiveLayout.this.aeY.a(InterviewLiveLayout.this.ahb, InterviewLiveLayout.this.adw);
                            return;
                        }
                        return;
                    }
                    l.showToast(InterviewLiveLayout.this.getContext(), (int) R.string.plugin_image_viewer_install_error_tips);
                }
            }
        };
        this.ahi = new TbImageView.c() { // from class: com.baidu.card.view.InterviewLiveLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                int i2;
                float f;
                float f2;
                float f3;
                float f4;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a yv = c.beu().yv(com.baidu.adp.lib.e.c.kX().genCacheKey(tbImageView.getUrl(), InterviewLiveLayout.this.aha ? 13 : 14));
                    if (yv != null) {
                        int width = yv.getWidth();
                        i = yv.getHeight();
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
        this.ahb = (TbImageView) findViewById(R.id.img_interview_live);
        this.ahb.nM(15);
        this.ahb.setPlaceHolder(3);
        this.ahc = (LinearLayout) findViewById(R.id.interview_live_tip_bg);
        this.ahd = (ImageView) findViewById(R.id.interview_live_tip_img);
        this.ahe = (TextView) findViewById(R.id.interview_live_tip);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setFromCDN(boolean z) {
        this.aha = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adw = absThreadDataSupport;
        if (absThreadDataSupport == null || this.ahb == null) {
            setVisibility(8);
            return;
        }
        bk aOi = absThreadDataSupport.aOi();
        bi aQd = aOi.aQd();
        if (aQd == null) {
            setVisibility(8);
            return;
        }
        this.ahg = aOi;
        this.forumId = aOi.getFid();
        this.taskId = aQd.getTaskId();
        if (k.aNQ().isShowImages() && aQd != null && !StringUtils.isNull(aQd.getThreadImgUrl())) {
            this.ahf.clear();
            this.ahf.add(aQd.getThreadImgUrl());
            setVisibility(0);
            this.ahb.setSupportNoImage(true);
            this.ahb.setScaleType(ImageView.ScaleType.MATRIX);
            this.ahb.setOnDrawListener(this.ahi);
            this.ahb.startLoad(aQd.getThreadImgUrl(), this.aha ? 13 : 14, false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88);
            layoutParams.height = (int) ((layoutParams.width * 428.0f) / 760.0f);
            setLayoutParams(layoutParams);
        } else {
            setVisibility(8);
        }
        this.ahb.setOnClickListener(this.ahh);
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.aeY = aaVar;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            am.setViewTextColor(this.ahe, (int) R.color.cp_cont_a);
            am.setImageResource(this.ahd, R.drawable.interview_live_circle_share);
            am.setBackgroundResource(this.ahc, R.drawable.interview_live_circle_bg_shape);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.ahb != null) {
            this.ahb.setPageId(bdUniqueId);
        }
    }
}
