package com.baidu.tbadk.core.voice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.core.voice.service.MediaService;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BroadcastReceiver {
    final /* synthetic */ VoiceManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(VoiceManager voiceManager) {
        this.this$0 = voiceManager;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String string;
        Runnable runnable;
        if (this.this$0.mCurPlayModel != null && intent != null) {
            String action = intent.getAction();
            if (action.equals("com.baidu.isPlaying")) {
                this.this$0.setVolumeControlStream();
                if (intent.getBooleanExtra("com.baidu.msg.isPlaying", false) && this.this$0.mCurPlayModel != null) {
                    if (this.this$0.mHandle != null) {
                        Handler handler = this.this$0.mHandle;
                        runnable = this.this$0.unRegistSensorRunnable;
                        handler.removeCallbacks(runnable);
                    }
                    try {
                        this.this$0.mCurPlayModel.voice_status = 3;
                        VoiceManager.b playView = this.this$0.getPlayView();
                        if (playView != null) {
                            playView.b(this.this$0.mCurPlayModel);
                        }
                    } catch (Exception e) {
                        l lVar = new l();
                        if (this.this$0.mCurPlayModel != null) {
                            lVar.n("id", this.this$0.mCurPlayModel.getId());
                            lVar.n("from", this.this$0.mCurPlayModel.from);
                        }
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_UPDATEVIEW, "mVoicePlayerReceiver.onReceive exception: " + e.getMessage(), lVar.toString());
                    }
                }
            } else if (action.equals("com.baidu.playElapsedTime")) {
                int intExtra = intent.getIntExtra("com.baidu.msg.playElapsedTime", 0);
                VoiceManager.b playView2 = this.this$0.getPlayView();
                if (playView2 != null) {
                    playView2.aS(intExtra);
                }
                if (this.this$0.mCurPlayModel != null) {
                    this.this$0.mCurPlayModel.elapse = intExtra;
                }
            } else if (action.equals("com.baidu.isStoped")) {
                VoiceManager.b playView3 = this.this$0.getPlayView();
                if (this.this$0.mCurPlayModel != null) {
                    if (!this.this$0.bStopAndReplay) {
                        this.this$0.releaseWakeLock();
                        this.this$0.setStatusWaiting(this.this$0.mCurPlayModel);
                        this.this$0.sPlayView = null;
                    }
                    this.this$0.mCurPlayModel = null;
                    if (this.this$0.bStopAndReplay && playView3 != null) {
                        VoiceData.VoiceModel voiceModel = playView3.getVoiceModel();
                        if (voiceModel != null) {
                            voiceModel.curr_time = intent.getIntExtra("com.baidu.msg.curr_time", 0);
                        }
                        if (this.this$0.mHandle != null) {
                            this.this$0.mHandle.removeCallbacks(this.this$0.stopVoiceAndRePlayRunnable);
                            this.this$0.mHandle.postDelayed(this.this$0.stopVoiceAndRePlayRunnable, 200L);
                        }
                    }
                }
            } else if (action.equals("com.baidu.playPrepared")) {
                int intExtra2 = intent.getIntExtra("com.baidu.playPrepared_err_code", -1);
                if (intExtra2 != -1) {
                    VoiceManager.b playView4 = this.this$0.getPlayView();
                    if (playView4 != null) {
                        if (intExtra2 == 2) {
                            string = com.baidu.adp.lib.voice.l.getString(r.j.voice_err_io);
                        } else {
                            string = com.baidu.adp.lib.voice.l.getString(r.j.voice_err_play);
                        }
                        playView4.onShowErr(5, string);
                    }
                    if (this.this$0.mCurPlayModel != null) {
                        this.this$0.setStatusWaiting(this.this$0.mCurPlayModel);
                        this.this$0.mCurPlayModel = null;
                        return;
                    }
                    return;
                }
                long longExtra = intent.getLongExtra("com.baidu.msg.durationTime2", this.this$0.mCurPlayModel != null ? this.this$0.mCurPlayModel.duration * 1000 : 0);
                if (longExtra > 900 && this.this$0.mCurPlayModel != null) {
                    this.this$0.mCurPlayModel.duration2 = (int) longExtra;
                }
                VoiceManager.b playView5 = this.this$0.getPlayView();
                if (playView5 != null) {
                    playView5.lD();
                }
                MediaService.startPlay(context);
            } else {
                action.equalsIgnoreCase("com.baidu.recognize");
            }
        }
    }
}
