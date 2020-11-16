package com.baidu.card.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.card.p;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import java.lang.ref.WeakReference;
/* loaded from: classes20.dex */
public class VideoImageNoPlayerLayout extends RelativeLayout implements p<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a afN;
    private View.OnClickListener afO;
    private a aiw;
    protected boolean akP;
    private TbImageView.c akv;
    public TbImageView alP;
    private ImageView alQ;
    private ImageView alR;
    private TextView alS;
    private TextView alT;
    private TextView alU;
    private WeakReference<Context> alV;
    public RelativeLayout alW;
    public RelativeLayout alX;
    protected boolean alY;
    protected String alZ;
    protected long ama;
    protected long amb;
    private ab<com.baidu.tbadk.core.data.a> amc;
    private Context mContext;
    protected long mFid;
    private int mSkinType;

    public VideoImageNoPlayerLayout(Context context) {
        super(context);
        this.mSkinType = 3;
        this.alV = null;
        this.akP = false;
        this.akv = new TbImageView.c() { // from class: com.baidu.card.view.VideoImageNoPlayerLayout.2
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
                    com.baidu.adp.widget.ImageView.a DA = c.bAt().DA(com.baidu.adp.lib.e.c.mS().genCacheKey(tbImageView.getUrl(), 10));
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
                            if (VideoImageNoPlayerLayout.this.akP && i > i2) {
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
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.video_image_no_player_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.alW = (RelativeLayout) findViewById(R.id.operable_video_container);
        this.alX = (RelativeLayout) findViewById(R.id.video_container);
        this.alV = new WeakReference<>(TbadkCoreApplication.getInst());
        this.alP = (TbImageView) findViewById(R.id.video_thumbnail);
        this.alQ = (ImageView) findViewById(R.id.video_play);
        this.alR = (ImageView) findViewById(R.id.video_pause);
        this.alS = (TextView) findViewById(R.id.video_play_count);
        this.alT = (TextView) findViewById(R.id.video_play_flag);
        this.alU = (TextView) findViewById(R.id.video_duration);
        this.alP.setConrers(15);
        this.alP.setRadiusById(R.string.J_X05);
        this.alP.setDrawCorner(true);
        this.alP.setPlaceHolder(3);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.VideoImageNoPlayerLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoImageNoPlayerLayout.this.amc != null) {
                    VideoImageNoPlayerLayout.this.amc.a(VideoImageNoPlayerLayout.this.alP, VideoImageNoPlayerLayout.this.afN);
                }
                if (VideoImageNoPlayerLayout.this.afO != null) {
                    VideoImageNoPlayerLayout.this.afO.onClick(VideoImageNoPlayerLayout.this.alP);
                }
            }
        });
        ap.setBackgroundResource(this, R.color.CAM_X0206);
    }

    @Override // android.view.View
    public View getRootView() {
        return this.alW;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.bjd() != null && aVar.bjd().eEF != null) {
            OriginalThreadInfo originalThreadInfo = aVar.bjd().eEF;
            this.alY = originalThreadInfo.videoInfo.is_vertical.intValue() == 1;
            this.alZ = originalThreadInfo.threadId;
            this.ama = originalThreadInfo.videoInfo.video_length.intValue();
            this.amb = originalThreadInfo.videoInfo.video_duration.intValue();
            this.mFid = originalThreadInfo.forumId;
            this.alU.setText(au.stringForVideoTime(originalThreadInfo.videoInfo.video_duration.intValue() * 1000));
            this.alS.setText(String.format(this.mContext.getResources().getString(R.string.play_count_new), au.numFormatOverWan(originalThreadInfo.videoInfo.play_count.intValue())));
            this.alT.setVisibility(8);
            this.alP.startLoad(originalThreadInfo.videoInfo.thumbnail_url, 10, false);
        }
    }

    public void setCanCenterStart(boolean z) {
        this.akP = z;
    }

    public void setOnCardSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.amc = abVar;
    }

    public void setVideoAreaClickListener(a aVar) {
        this.aiw = aVar;
        if (aVar != null) {
            ub();
        }
    }

    private void ub() {
        if (this.alX != null) {
            this.alX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.VideoImageNoPlayerLayout.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    VideoImageNoPlayerLayout.this.aiw.a(VideoImageNoPlayerLayout.this.afN);
                }
            });
        }
    }

    public void setData(com.baidu.tbadk.core.data.a aVar) {
        this.afN = aVar;
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundColor(this.alW, R.color.CAM_X0206);
            ap.setBackgroundColor(this.alX, R.color.CAM_X0206);
            ap.setBackgroundColor(this, R.color.CAM_X0206);
            this.alQ.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_play44, ap.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            this.alR.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_pause44, ap.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        }
        this.mSkinType = i;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.afO = onClickListener;
    }
}
