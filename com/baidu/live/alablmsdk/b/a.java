package com.baidu.live.alablmsdk.b;

import android.text.TextUtils;
import com.baidu.android.imrtc.utils.IStatusListener;
import com.baidu.live.alablmsdk.a.d;
import com.baidu.live.alablmsdk.module.UserPermission;
import com.baidu.live.alablmsdk.module.state.BLMLegacyRoomStatus;
/* loaded from: classes4.dex */
public class a {
    private static String aBQ = "";
    private com.baidu.live.alablmsdk.e.b aBO;
    com.baidu.live.alablmsdk.module.b.a aBP;

    public a(com.baidu.live.alablmsdk.e.b bVar) {
        this.aBO = bVar;
    }

    public static void ga(String str) {
        com.baidu.live.alablmsdk.a.b.a.ak("setCurrentRoomId " + str, "");
        aBQ = str;
    }

    public void a(String str, UserPermission userPermission) {
        this.aBP = new com.baidu.live.alablmsdk.module.b.a(str, userPermission.getPermission(), BLMLegacyRoomStatus.LOGIC_ACTIVE.getStatus());
        String jsonString = this.aBP.toJsonString();
        com.baidu.live.alablmsdk.a.b.a.d(" putCurrentRoomInfo roomInfo=" + jsonString);
        com.baidu.live.alablmsdk.a.b.a.fY(" putCurrentRoomInfo roomInfo " + jsonString);
        d.BT().putString("legacy_room_info_kye", jsonString);
    }

    public void a(BLMLegacyRoomStatus bLMLegacyRoomStatus) {
        if (this.aBP != null) {
            this.aBP.aCI = bLMLegacyRoomStatus.getStatus();
            String jsonString = this.aBP.toJsonString();
            com.baidu.live.alablmsdk.a.b.a.d(" updateCurrentRoomStatus  roomInfo=" + jsonString);
            com.baidu.live.alablmsdk.a.b.a.fY(" updateCurrentRoomStatus roomInfo " + jsonString);
            d.BT().putString("legacy_room_info_kye", jsonString);
        }
    }

    public void Cu() {
        d.BT().putString("legacy_room_info_kye", "");
    }

    public void Cv() {
        com.baidu.live.alablmsdk.a.b.a.d(" handleLongConnectionLegacyRoom ");
        com.baidu.live.alablmsdk.a.b.a.fY(" handleLongConnectionLegacyRoom ");
        if (this.aBP != null && !TextUtils.isEmpty(this.aBP.roomId) && this.aBP.aCI == BLMLegacyRoomStatus.LOGIC_END_FAIL.getStatus() && this.aBO != null) {
            final String str = this.aBP.roomId;
            if (this.aBP.permission == UserPermission.OWNER.getPermission()) {
                com.baidu.live.alablmsdk.a.b.a.d(" handleLongConnectionLegacyRoom  closeRoom");
                com.baidu.live.alablmsdk.a.b.a.fY(" handleLongConnectionLegacyRoom  closeRoom");
                this.aBO.a(this.aBP.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.a.1
                    @Override // com.baidu.android.imrtc.utils.IStatusListener
                    public void onResult(int i, String str2) {
                        com.baidu.live.alablmsdk.a.b.a.d(" handleLongConnectionLegacyRoom closeRoom onResult code=" + i);
                        com.baidu.live.alablmsdk.a.b.a.fY(" handleLongConnectionLegacyRoom closeRoom onResult code=" + i);
                        if (i == 0) {
                            com.baidu.live.alablmsdk.a.b.a.d(" handleLongConnectionLegacyRoom closeRoom  success");
                            com.baidu.live.alablmsdk.a.b.a.fY(" handleLongConnectionLegacyRoom closeRoom  success");
                            if (!TextUtils.isEmpty(str) && str.equals(a.this.aBP.roomId)) {
                                com.baidu.live.alablmsdk.a.b.a.d(" handleLongConnectionLegacyRoom  clearLegacyRoomInfo");
                                com.baidu.live.alablmsdk.a.b.a.fY(" handleLongConnectionLegacyRoom  clearLegacyRoomInfo");
                                a.this.Cu();
                            }
                        }
                    }
                });
                return;
            }
            com.baidu.live.alablmsdk.a.b.a.d(" handleLongConnectionLegacyRoom  hangout");
            com.baidu.live.alablmsdk.a.b.a.fY(" handleLongConnectionLegacyRoom  hangout");
            this.aBO.hangout(this.aBP.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.a.2
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str2) {
                    if (i == 0) {
                        com.baidu.live.alablmsdk.a.b.a.d(" handleLongConnectionLegacyRoom hangout onResult code=" + i);
                        com.baidu.live.alablmsdk.a.b.a.fY(" handleLongConnectionLegacyRoom hangout onResult code=" + i);
                        if (!TextUtils.isEmpty(str) && str.equals(a.this.aBP.roomId)) {
                            a.this.Cu();
                            return;
                        }
                        return;
                    }
                    com.baidu.live.alablmsdk.a.b.a.d(" handleLongConnectionLegacyRoom hangout fail , code=" + i);
                    com.baidu.live.alablmsdk.a.b.a.fY(" handleLongConnectionLegacyRoom hangout fail code " + i);
                }
            });
        }
    }

    public void Cw() {
        String string = d.BT().getString("legacy_room_info_kye");
        com.baidu.live.alablmsdk.a.b.a.ak(" closeLegacyRoom legacyRoomInfo " + string + " , mCurrentRoomId=" + aBQ, "");
        this.aBP = com.baidu.live.alablmsdk.module.b.a.gg(string);
        if (this.aBP != null && !TextUtils.isEmpty(this.aBP.roomId) && !this.aBP.roomId.equals(aBQ)) {
            if ((this.aBP.aCI == BLMLegacyRoomStatus.LOGIC_ACTIVE.getStatus() || this.aBP.aCI == BLMLegacyRoomStatus.LOGIC_END_FAIL.getStatus()) && this.aBO != null) {
                com.baidu.live.alablmsdk.a.b.a.ak(" closeLegacyRoom  closeRoom, mLegacyRoomInfo.roomId=" + this.aBP.roomId, "");
                if (this.aBP.permission == UserPermission.OWNER.getPermission()) {
                    this.aBO.a(this.aBP.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.a.3
                        @Override // com.baidu.android.imrtc.utils.IStatusListener
                        public void onResult(int i, String str) {
                            if (i == 0) {
                                com.baidu.live.alablmsdk.a.b.a.d(" handleInitLegacyRoom closeRoom  success , clearLegacyRoomInfo");
                                com.baidu.live.alablmsdk.a.b.a.fY(" handleInitLegacyRoom closeRoom success clearLegacyRoomInfo");
                                a.this.Cu();
                            }
                        }
                    });
                    return;
                }
                com.baidu.live.alablmsdk.a.b.a.d(" handleInitLegacyRoom  hangout");
                com.baidu.live.alablmsdk.a.b.a.fY(" handleInitLegacyRoom  hangout");
                this.aBO.hangout(this.aBP.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.a.4
                    @Override // com.baidu.android.imrtc.utils.IStatusListener
                    public void onResult(int i, String str) {
                        if (i == 0) {
                            com.baidu.live.alablmsdk.a.b.a.d(" handleInitLegacyRoom hangout success , clearLegacyRoomInfo");
                            com.baidu.live.alablmsdk.a.b.a.fY(" handleInitLegacyRoom hangout success clearLegacyRoomInfo");
                            a.this.Cu();
                        }
                    }
                });
            }
        }
    }

    public void release() {
        aBQ = "";
    }
}
