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
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class InterviewLiveLayout extends FrameLayout implements n<AbsThreadDataSupport> {
    private AbsThreadDataSupport aea;
    private aa<AbsThreadDataSupport> afH;
    private boolean aik;
    private TbImageView ail;
    private LinearLayout aim;
    private ImageView ain;
    private TextView aio;
    private ArrayList<String> aip;
    private bu aiq;
    private View.OnClickListener air;
    private TbImageView.c ais;
    private long forumId;
    private int mSkinType;
    private String taskId;

    public InterviewLiveLayout(Context context) {
        this(context, null);
    }

    public InterviewLiveLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.aik = true;
        this.aea = null;
        this.aip = new ArrayList<>();
        this.air = new View.OnClickListener() { // from class: com.baidu.card.view.InterviewLiveLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (w.getCount(InterviewLiveLayout.this.aip) > 0) {
                    if (TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
                        String str = (String) InterviewLiveLayout.this.aip.get(0);
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.urlType = InterviewLiveLayout.this.aik ? 13 : 14;
                        imageUrlData.imageUrl = str;
                        imageUrlData.originalUrl = str;
                        imageUrlData.originalSize = 0L;
                        imageUrlData.isLongPic = false;
                        imageUrlData.mIsShowOrigonButton = false;
                        imageUrlData.threadId = 0L;
                        imageUrlData.postId = 0L;
                        concurrentHashMap.put(str, imageUrlData);
                        ImageViewerConfig createConfig = new ImageViewerConfig(InterviewLiveLayout.this.getContext()).createConfig(InterviewLiveLayout.this.aip, 0, "", "", "", InterviewLiveLayout.this.aik, str, false, concurrentHashMap, false);
                        createConfig.getIntent().putExtra("from", "frs");
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        createConfig.getIntent().putExtra("source_rect_in_screen", rect);
                        createConfig.setIsShowHost(false);
                        createConfig.setThreadData(InterviewLiveLayout.this.aiq);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                        ao aoVar = new ao("c13327");
                        aoVar.s("fid", InterviewLiveLayout.this.forumId);
                        aoVar.dk("obj_id", InterviewLiveLayout.this.taskId);
                        TiebaStatic.log(aoVar);
                        if (InterviewLiveLayout.this.afH != null) {
                            InterviewLiveLayout.this.afH.a(InterviewLiveLayout.this.ail, InterviewLiveLayout.this.aea);
                            return;
                        }
                        return;
                    }
                    l.showToast(InterviewLiveLayout.this.getContext(), (int) R.string.plugin_image_viewer_install_error_tips);
                }
            }
        };
        this.ais = new TbImageView.c() { // from class: com.baidu.card.view.InterviewLiveLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                int i2;
                float f;
                float f2;
                float f3;
                float f4;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a yO = c.bgz().yO(com.baidu.adp.lib.e.c.ln().genCacheKey(tbImageView.getUrl(), InterviewLiveLayout.this.aik ? 13 : 14));
                    if (yO != null) {
                        int width = yO.getWidth();
                        i = yO.getHeight();
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
        this.ail = (TbImageView) findViewById(R.id.img_interview_live);
        this.ail.oi(15);
        this.ail.setPlaceHolder(3);
        this.aim = (LinearLayout) findViewById(R.id.interview_live_tip_bg);
        this.ain = (ImageView) findViewById(R.id.interview_live_tip_img);
        this.aio = (TextView) findViewById(R.id.interview_live_tip);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setFromCDN(boolean z) {
        this.aik = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.aea = absThreadDataSupport;
        if (absThreadDataSupport == null || this.ail == null) {
            setVisibility(8);
            return;
        }
        bu aPS = absThreadDataSupport.aPS();
        bs aRV = aPS.aRV();
        if (aRV == null) {
            setVisibility(8);
            return;
        }
        this.aiq = aPS;
        this.forumId = aPS.getFid();
        this.taskId = aRV.getTaskId();
        if (k.aPA().isShowImages() && aRV != null && !StringUtils.isNull(aRV.getThreadImgUrl())) {
            this.aip.clear();
            this.aip.add(aRV.getThreadImgUrl());
            setVisibility(0);
            this.ail.setSupportNoImage(true);
            this.ail.setScaleType(ImageView.ScaleType.MATRIX);
            this.ail.setOnDrawListener(this.ais);
            this.ail.startLoad(aRV.getThreadImgUrl(), this.aik ? 13 : 14, false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88);
            layoutParams.height = (int) ((layoutParams.width * 428.0f) / 760.0f);
            setLayoutParams(layoutParams);
        } else {
            setVisibility(8);
        }
        this.ail.setOnClickListener(this.air);
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.afH = aaVar;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            an.setViewTextColor(this.aio, (int) R.color.cp_cont_a);
            an.setImageResource(this.ain, R.drawable.interview_live_circle_share);
            an.setBackgroundResource(this.aim, R.drawable.interview_live_circle_bg_shape);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.ail != null) {
            this.ail.setPageId(bdUniqueId);
        }
    }
}
