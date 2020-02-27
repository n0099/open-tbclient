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
import com.baidu.card.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class InterviewLiveLayout extends FrameLayout implements m<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a Kc;
    private z<com.baidu.tbadk.core.data.a> LD;
    private boolean NJ;
    private TbImageView NK;
    private LinearLayout NL;
    private ImageView NM;
    private TextView NN;
    private ArrayList<String> NP;
    private bj NQ;
    private View.OnClickListener NR;
    private TbImageView.c NT;
    private long forumId;
    private int mSkinType;
    private String taskId;

    public InterviewLiveLayout(Context context) {
        this(context, null);
    }

    public InterviewLiveLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.NJ = true;
        this.Kc = null;
        this.NP = new ArrayList<>();
        this.NR = new View.OnClickListener() { // from class: com.baidu.card.view.InterviewLiveLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (v.getCount(InterviewLiveLayout.this.NP) > 0) {
                    if (TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
                        String str = (String) InterviewLiveLayout.this.NP.get(0);
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.urlType = InterviewLiveLayout.this.NJ ? 13 : 14;
                        imageUrlData.imageUrl = str;
                        imageUrlData.originalUrl = str;
                        imageUrlData.originalSize = 0L;
                        imageUrlData.isLongPic = false;
                        imageUrlData.mIsShowOrigonButton = false;
                        imageUrlData.threadId = 0L;
                        imageUrlData.postId = 0L;
                        concurrentHashMap.put(str, imageUrlData);
                        ImageViewerConfig createConfig = new ImageViewerConfig(InterviewLiveLayout.this.getContext()).createConfig(InterviewLiveLayout.this.NP, 0, "", "", "", InterviewLiveLayout.this.NJ, str, false, concurrentHashMap, false);
                        createConfig.getIntent().putExtra("from", "frs");
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        createConfig.getIntent().putExtra("source_rect_in_screen", rect);
                        createConfig.setIsShowHost(false);
                        createConfig.setThreadData(InterviewLiveLayout.this.NQ);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                        an anVar = new an("c13327");
                        anVar.s("fid", InterviewLiveLayout.this.forumId);
                        anVar.cy("obj_id", InterviewLiveLayout.this.taskId);
                        TiebaStatic.log(anVar);
                        if (InterviewLiveLayout.this.LD != null) {
                            InterviewLiveLayout.this.LD.a(InterviewLiveLayout.this.NK, InterviewLiveLayout.this.Kc);
                            return;
                        }
                        return;
                    }
                    l.showToast(InterviewLiveLayout.this.getContext(), (int) R.string.plugin_image_viewer_install_error_tips);
                }
            }
        };
        this.NT = new TbImageView.c() { // from class: com.baidu.card.view.InterviewLiveLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                int i2;
                float f;
                float f2;
                float f3;
                float f4;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a vx = c.aPO().vx(com.baidu.adp.lib.e.c.gr().genCacheKey(tbImageView.getUrl(), InterviewLiveLayout.this.NJ ? 13 : 14));
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
        this.NK = (TbImageView) findViewById(R.id.img_interview_live);
        this.NK.mU(15);
        this.NK.setPlaceHolder(3);
        this.NL = (LinearLayout) findViewById(R.id.interview_live_tip_bg);
        this.NM = (ImageView) findViewById(R.id.interview_live_tip_img);
        this.NN = (TextView) findViewById(R.id.interview_live_tip);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setFromCDN(boolean z) {
        this.NJ = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.Kc = aVar;
        if (aVar == null || this.NK == null) {
            setVisibility(8);
            return;
        }
        bj aAe = aVar.aAe();
        bh aBS = aAe.aBS();
        if (aBS == null) {
            setVisibility(8);
            return;
        }
        this.NQ = aAe;
        this.forumId = aAe.getFid();
        this.taskId = aBS.getTaskId();
        if (i.azM().isShowImages() && aBS != null && !StringUtils.isNull(aBS.getThreadImgUrl())) {
            this.NP.clear();
            this.NP.add(aBS.getThreadImgUrl());
            setVisibility(0);
            this.NK.setSupportNoImage(true);
            this.NK.setScaleType(ImageView.ScaleType.MATRIX);
            this.NK.setOnDrawListener(this.NT);
            this.NK.startLoad(aBS.getThreadImgUrl(), this.NJ ? 13 : 14, false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88);
            layoutParams.height = (int) ((layoutParams.width * 428.0f) / 760.0f);
            setLayoutParams(layoutParams);
        } else {
            setVisibility(8);
        }
        this.NK.setOnClickListener(this.NR);
    }

    public void setSubClickListener(z<com.baidu.tbadk.core.data.a> zVar) {
        this.LD = zVar;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            am.setViewTextColor(this.NN, (int) R.color.cp_cont_a);
            am.setImageResource(this.NM, R.drawable.interview_live_circle_share);
            am.setBackgroundResource(this.NL, R.drawable.interview_live_circle_bg_shape);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.NK != null) {
            this.NK.setPageId(bdUniqueId);
        }
    }
}
