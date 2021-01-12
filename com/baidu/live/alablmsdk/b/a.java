package com.baidu.live.alablmsdk.b;

import android.text.TextUtils;
import com.baidu.android.imrtc.utils.IStatusListener;
import com.baidu.live.alablmsdk.a.d;
import com.baidu.live.alablmsdk.module.UserPermission;
import com.baidu.live.alablmsdk.module.state.BLMLegacyRoomStatus;
/* loaded from: classes10.dex */
public class a {
    private static String axu = "";
    private com.baidu.live.alablmsdk.e.b axs;
    com.baidu.live.alablmsdk.module.b.a axt;

    public a(com.baidu.live.alablmsdk.e.b bVar) {
        this.axs = bVar;
    }

    public static void ez(String str) {
        com.baidu.live.alablmsdk.a.b.a.ai("setCurrentRoomId " + str, "");
        axu = str;
    }

    public void a(String str, UserPermission userPermission) {
        this.axt = new com.baidu.live.alablmsdk.module.b.a(str, userPermission.getPermission(), BLMLegacyRoomStatus.LOGIC_ACTIVE.getStatus());
        String jsonString = this.axt.toJsonString();
        com.baidu.live.alablmsdk.a.b.a.d(" putCurrentRoomInfo roomInfo=" + jsonString);
        com.baidu.live.alablmsdk.a.b.a.ew(" putCurrentRoomInfo roomInfo " + jsonString);
        d.xp().putString("legacy_room_info_kye", jsonString);
    }

    public void a(BLMLegacyRoomStatus bLMLegacyRoomStatus) {
        if (this.axt != null) {
            this.axt.aym = bLMLegacyRoomStatus.getStatus();
            String jsonString = this.axt.toJsonString();
            com.baidu.live.alablmsdk.a.b.a.d(" updateCurrentRoomStatus  roomInfo=" + jsonString);
            com.baidu.live.alablmsdk.a.b.a.ew(" updateCurrentRoomStatus roomInfo " + jsonString);
            d.xp().putString("legacy_room_info_kye", jsonString);
        }
    }

    public void xQ() {
        d.xp().putString("legacy_room_info_kye", "");
    }

    public void xR() {
        com.baidu.live.alablmsdk.a.b.a.d(" handleLongConnectionLegacyRoom ");
        com.baidu.live.alablmsdk.a.b.a.ew(" handleLongConnectionLegacyRoom ");
        if (this.axt != null && !TextUtils.isEmpty(this.axt.roomId) && this.axt.aym == BLMLegacyRoomStatus.LOGIC_END_FAIL.getStatus() && this.axs != null) {
            final String str = this.axt.roomId;
            if (this.axt.permission == UserPermission.OWNER.getPermission()) {
                com.baidu.live.alablmsdk.a.b.a.d(" handleLongConnectionLegacyRoom  closeRoom");
                com.baidu.live.alablmsdk.a.b.a.ew(" handleLongConnectionLegacyRoom  closeRoom");
                this.axs.a(this.axt.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.a.1
                    @Override // com.baidu.android.imrtc.utils.IStatusListener
                    public void onResult(int i, String str2) {
                        com.baidu.live.alablmsdk.a.b.a.d(" handleLongConnectionLegacyRoom closeRoom onResult code=" + i);
                        com.baidu.live.alablmsdk.a.b.a.ew(" handleLongConnectionLegacyRoom closeRoom onResult code=" + i);
                        if (i == 0) {
                            com.baidu.live.alablmsdk.a.b.a.d(" handleLongConnectionLegacyRoom closeRoom  success");
                            com.baidu.live.alablmsdk.a.b.a.ew(" handleLongConnectionLegacyRoom closeRoom  success");
                            if (!TextUtils.isEmpty(str) && str.equals(a.this.axt.roomId)) {
                                com.baidu.live.alablmsdk.a.b.a.d(" handleLongConnectionLegacyRoom  clearLegacyRoomInfo");
                                com.baidu.live.alablmsdk.a.b.a.ew(" handleLongConnectionLegacyRoom  clearLegacyRoomInfo");
                                a.this.xQ();
                            }
                        }
                    }
                });
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.d(" handleLongConnectionLegacyRoom  hangout");
            com.baidu.live.alablmsdk.a.b.a.ew(" handleLongConnectionLegacyRoom  hangout");
            this.axs.hangout(this.axt.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.a.2
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str2) {
                    if (i == 0) {
                        com.baidu.live.alablmsdk.a.b.a.d(" handleLongConnectionLegacyRoom hangout onResult code=" + i);
                        com.baidu.live.alablmsdk.a.b.a.ew(" handleLongConnectionLegacyRoom hangout onResult code=" + i);
                        if (!TextUtils.isEmpty(str) && str.equals(a.this.axt.roomId)) {
                            a.this.xQ();
                            return;
                        }
                        return;
                    }
                    com.baidu.live.alablmsdk.a.b.a.d(" handleLongConnectionLegacyRoom hangout fail , code=" + i);
                    com.baidu.live.alablmsdk.a.b.a.ew(" handleLongConnectionLegacyRoom hangout fail code " + i);
                }
            });
        }
    }

    public void xS() {
        String string = d.xp().getString("legacy_room_info_kye");
        com.baidu.live.alablmsdk.a.b.a.ai(" closeLegacyRoom legacyRoomInfo " + string + " , mCurrentRoomId=" + axu, "");
        this.axt = com.baidu.live.alablmsdk.module.b.a.eF(string);
        if (this.axt != null && !TextUtils.isEmpty(this.axt.roomId) && !this.axt.roomId.equals(axu)) {
            if ((this.axt.aym == BLMLegacyRoomStatus.LOGIC_ACTIVE.getStatus() || this.axt.aym == BLMLegacyRoomStatus.LOGIC_END_FAIL.getStatus()) && this.axs != null) {
                com.baidu.live.alablmsdk.a.b.a.ai(" closeLegacyRoom  closeRoom, mLegacyRoomInfo.roomId=" + this.axt.roomId, "");
                if (this.axt.permission == UserPermission.OWNER.getPermission()) {
                    this.axs.a(this.axt.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.a.3
                        @Override // com.baidu.android.imrtc.utils.IStatusListener
                        public void onResult(int i, String str) {
                            if (i == 0) {
                                com.baidu.live.alablmsdk.a.b.a.d(" handleInitLegacyRoom closeRoom  success , clearLegacyRoomInfo");
                                com.baidu.live.alablmsdk.a.b.a.ew(" handleInitLegacyRoom closeRoom success clearLegacyRoomInfo");
                                a.this.xQ();
                            }
                        }
                    });
                    return;
                }
                com.baidu.live.alablmsdk.a.b.a.d(" handleInitLegacyRoom  hangout");
                com.baidu.live.alablmsdk.a.b.a.ew(" handleInitLegacyRoom  hangout");
                this.axs.hangout(this.axt.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.a.4
                    @Override // com.baidu.android.imrtc.utils.IStatusListener
                    public void onResult(int i, String str) {
                        if (i == 0) {
                            com.baidu.live.alablmsdk.a.b.a.d(" handleInitLegacyRoom hangout success , clearLegacyRoomInfo");
                            com.baidu.live.alablmsdk.a.b.a.ew(" handleInitLegacyRoom hangout success clearLegacyRoomInfo");
                            a.this.xQ();
                        }
                    }
                });
            }
        }
    }

    public void release() {
        axu = "";
    }
}
